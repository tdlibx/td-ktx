package org.drinkless.tdlib

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.isActive
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

open class TdKtxClient(
    private val timeout: Double = 1.0,
    private val engine: TdEngine = TdClientEngine()
) {
    private val clientId = engine.createClient()

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    val updates = flow {
        while (scope.isActive) {
            try {
                // Receive response from TDLib.
                // Timeout is in seconds.
                val response = engine.receive(clientId, timeout)
                if (response != null) {
                    emit(response)

                    val extraId = extractExtra(response)
                    if (extraId != null) {
                        val deferred = pendingRequests.withLock {
                            callbacks.remove(extraId)
                        }
                        deferred?.complete(response)
                    }
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                println("TD_FLOW_DEBUG: TdKtxClient error: ${e.message}")

                // Continue loop in case of non-cancellation exceptions
            }
        }
    }.shareIn(scope, SharingStarted.WhileSubscribed(5000), 1000)


    private val pendingRequests = Mutex()
    internal val callbacks = HashMap<String, CompletableDeferred<String>>()

    private val counterMutex = Mutex()
    private var counter = 0L

    private val extraRegex = """"@extra"\s*:\s*(?:"([^"]*)"|(\d+))""".toRegex()

    private fun extractExtra(json: String): String? {
        val match = extraRegex.find(json) ?: return null
        return match.groupValues[1].takeIf { it.isNotEmpty() } ?: match.groupValues[2]
    }

    suspend fun sendJson(query: String): String {
        val trimmed = query.trim()
        require(trimmed.startsWith("{") && trimmed.endsWith("}")) { "Query must be a JSON object" }

        val extraId = "ktx_" + counterMutex.withLock { ++counter }
        val deferred = CompletableDeferred<String>()

        pendingRequests.withLock {
            callbacks[extraId] = deferred
        }

        val body = trimmed.substring(1)
        val injectedQuery = """{"@extra":"$extraId",$body"""

        try {
            engine.send(clientId, injectedQuery)
        } catch (e: Exception) {
            pendingRequests.withLock {
                callbacks.remove(extraId)
            }
            throw e
        }

        try {
            return deferred.await()
        } finally {
            pendingRequests.withLock {
                callbacks.remove(extraId)
            }
        }
    }

    fun release() {
        scope.cancel()
    }
}
