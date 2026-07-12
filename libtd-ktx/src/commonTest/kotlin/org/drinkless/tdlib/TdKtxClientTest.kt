package org.drinkless.tdlib

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class FakeTdEngine : TdEngine {
    private val sentQueriesMutex = Mutex()
    private val sentQueries = mutableListOf<String>()
    private val queue = Channel<String>(Channel.UNLIMITED)

    fun injectResponse(response: String) {
        queue.trySend(response)
    }

    fun getSentQueries(): List<String> {
        return runBlocking {
            sentQueriesMutex.withLock {
                sentQueries.toList()
            }
        }
    }

    override fun createClient(): Long {
        return 42L
    }

    override fun send(clientId: Long, jsonQuery: String) {
        runBlocking {
            sentQueriesMutex.withLock {
                sentQueries.add(jsonQuery)
            }
        }
    }

    override fun receive(clientId: Long, timeout: Double): String? {
        return runBlocking {
            withTimeoutOrNull((timeout * 1000).toLong()) {
                queue.receive()
            }
        }
    }
}

class TdKtxClientTest {

    @Test
    fun testConcurrentRequests() = runTest {
        val fakeEngine = FakeTdEngine()
        val client = TdKtxClient(timeout = 0.1, engine = fakeEngine)

        val coroutinesCount = 5
        val deferreds = List(coroutinesCount) { i ->
            async {
                client.sendJson("""{"value":$i}""")
            }
        }

        // Wait until all queries are sent by the client.
        var sent: List<String> = emptyList()
        withTimeout(5000) {
            while (true) {
                sent = fakeEngine.getSentQueries()
                if (sent.size >= coroutinesCount) break
                delay(10)
            }
        }

        // Verify they all have unique extras.
        val extraRegex = """"@extra"\s*:\s*"([^"]+)"""".toRegex()
        val extras = sent.map { query ->
            val match = extraRegex.find(query)
            assertNotNull(match, "Query should have @extra injected")
            match.groupValues[1]
        }
        assertEquals(coroutinesCount, extras.distinct().size, "All @extra IDs should be unique")

        // Inject responses in reverse order to prove order independence.
        for (i in (coroutinesCount - 1) downTo 0) {
            val extra = extras[i]
            val simulatedResponse = """{"@extra":"$extra","result":"result_$i"}"""
            fakeEngine.injectResponse(simulatedResponse)
        }

        // Wait for all deferreds to complete and assert their values.
        val results = deferreds.awaitAll()
        for (i in 0 until coroutinesCount) {
            assertTrue(results[i].contains("result_$i"), "Result should match the injected response")
        }

        client.release()
    }

    @Test
    fun testUpdatePipeline() = runTest {
        val fakeEngine = FakeTdEngine()
        val client = TdKtxClient(timeout = 0.1, engine = fakeEngine)

        val updatesReceived = mutableListOf<String>()
        val collectJob = launch {
            client.updates.collect { update ->
                updatesReceived.add(update)
            }
        }

        // Yield to let collection start.
        delay(50)

        // Inject simulated system updates without @extra.
        val simulatedUpdate1 = """{"@type":"updateUser","user_id":123}"""
        val simulatedUpdate2 = """{"@type":"updateNewMessage","message_id":456}"""
        
        fakeEngine.injectResponse(simulatedUpdate1)
        fakeEngine.injectResponse(simulatedUpdate2)

        // Wait for updates to be collected.
        withTimeout(2000) {
            while (updatesReceived.size < 2) {
                delay(10)
            }
        }

        assertEquals(2, updatesReceived.size)
        assertEquals(simulatedUpdate1, updatesReceived[0])
        assertEquals(simulatedUpdate2, updatesReceived[1])

        collectJob.cancel()
        client.release()
    }

    @Test
    fun testTimeoutAndCleanupProtection() = runTest {
        val fakeEngine = FakeTdEngine()
        val client = TdKtxClient(timeout = 0.1, engine = fakeEngine)

        // 1. Test normal lifecycle completion removes from callbacks map
        val normalJob = launch {
            client.sendJson("""{"value":1}""")
        }

        // Wait until it is registered in callbacks
        var ktxExtraId: String? = null
        withTimeout(2000) {
            while (true) {
                val currentCallbacks = client.callbacks
                if (currentCallbacks.isNotEmpty()) {
                    ktxExtraId = currentCallbacks.keys.first()
                    break
                }
                delay(10)
            }
        }
        
        assertNotNull(ktxExtraId)
        assertEquals(1, client.callbacks.size, "Callbacks should contain the request before response")

        // Inject response to complete normally
        fakeEngine.injectResponse("""{"@extra":"$ktxExtraId","result":"ok"}""")
        normalJob.join()

        assertEquals(0, client.callbacks.size, "Callbacks should be empty after normal completion")

        // 2. Test cancellation (dropout) removes from callbacks map
        val cancelJob = launch {
            try {
                client.sendJson("""{"value":2}""")
            } catch (e: CancellationException) {
                // Expected when cancelled
            }
        }

        // Wait until it is registered in callbacks
        var cancelExtraId: String? = null
        withTimeout(2000) {
            while (true) {
                val currentCallbacks = client.callbacks
                if (currentCallbacks.isNotEmpty()) {
                    cancelExtraId = currentCallbacks.keys.first()
                    break
                }
                delay(10)
            }
        }
        
        assertNotNull(cancelExtraId)
        assertEquals(1, client.callbacks.size, "Callbacks should contain the request")

        // Cancel the job calling sendJson
        cancelJob.cancelAndJoin()

        assertEquals(0, client.callbacks.size, "Callbacks should be cleaned up immediately on cancellation")

        client.release()
    }
}
