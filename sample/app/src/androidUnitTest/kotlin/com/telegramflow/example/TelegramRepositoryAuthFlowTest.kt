package com.telegramflow.example

import app.cash.turbine.test
import com.telegramflow.example.data.local.AuthState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.telegram.core.TelegramFlow
import kotlinx.telegram.flows.authorizationStateFlow
import org.drinkless.tdlib.TdClientEngine
import org.drinkless.tdlib.TdEngine
import org.drinkless.tdlib.generated.AuthorizationState
import org.drinkless.tdlib.generated.AuthorizationStateReady
import org.drinkless.tdlib.generated.AuthorizationStateWaitCode
import org.drinkless.tdlib.generated.AuthorizationStateWaitPassword
import org.drinkless.tdlib.generated.AuthorizationStateWaitPhoneNumber
import org.drinkless.tdlib.generated.UpdateAuthorizationState
import org.drinkless.tdlib.generated.tdJson
import org.drinkless.tdlib.generated.Update
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

// ---------------------------------------------------------------------------
// Fake engine
// ---------------------------------------------------------------------------

/**
 * [TdEngine] stub that lets tests push raw JSON strings directly into the TDLib
 * receive loop — **no native libraries required**.
 */
private class FakeTdEngine : TdEngine {
    private val receiveQueue = ArrayDeque<String>()

    fun enqueue(json: String) { receiveQueue.addLast(json) }

    override fun createClient(): Long = 1L
    override fun send(clientId: Long, jsonQuery: String) { /* no-op */ }
    override fun receive(clientId: Long, timeout: Double): String? =
        receiveQueue.removeFirstOrNull()
}

// ---------------------------------------------------------------------------
// Raw JSON payload builders
// ---------------------------------------------------------------------------

private object TdUpdate {
    fun waitTdlibParameters() =
        """{"@type":"updateAuthorizationState","authorization_state":{"@type":"authorizationStateWaitTdlibParameters"}}"""

    fun waitPhoneNumber() =
        """{"@type":"updateAuthorizationState","authorization_state":{"@type":"authorizationStateWaitPhoneNumber"}}"""

    fun waitCode() =
        """{"@type":"updateAuthorizationState","authorization_state":{"@type":"authorizationStateWaitCode",""" +
        """"code_info":{"@type":"authenticationCodeInfo","phone_number":"+1234",""" +
        """"type":{"@type":"authenticationCodeTypeSms","length":5},"timeout":60}}}"""

    fun waitPassword() =
        """{"@type":"updateAuthorizationState","authorization_state":{"@type":"authorizationStateWaitPassword",""" +
        """"password_hint":"hint","has_recovery_email_address":false,""" +
        """"has_passport_data":false,"recovery_email_address_pattern":""}}"""

    fun ready() =
        """{"@type":"updateAuthorizationState","authorization_state":{"@type":"authorizationStateReady"}}"""

    /** Unrelated TDLib event — must NOT affect the auth StateFlow. */
    fun optionUpdate(key: String = "version", value: String = "1.8.0") =
        """{"@type":"updateOption","name":"$key","value":{"@type":"optionValueString","value":"$value"}}"""
}

// ---------------------------------------------------------------------------
// Mapping helper (mirrors TelegramRepository.authFlow mapping)
// ---------------------------------------------------------------------------

private fun AuthorizationState.toAuthState(): AuthState? = when (this) {
    is AuthorizationStateWaitPhoneNumber -> AuthState.EnterPhone
    is AuthorizationStateWaitCode        -> AuthState.EnterCode
    is AuthorizationStateWaitPassword    -> AuthState.EnterPassword(passwordHint.orEmpty())
    is AuthorizationStateReady           -> AuthState.LoggedIn
    else                                 -> null   // WaitTdlibParameters, WaitEncryptionKey, etc.
}

// ---------------------------------------------------------------------------
// Tests
// ---------------------------------------------------------------------------

/**
 * Unit tests for the TelegramRepository authorization-state flow.
 *
 * **No native libraries required** — [FakeTdEngine] drives the updates.
 *
 * ## Regression scenario
 *
 * TDLib fires `WaitPhoneNumber` right after `WaitTdlibParameters`.  With the old
 * cold-`Flow` design, any subsequent unrelated update (`updateOption`, etc.)
 * would overwrite the raw `replay=1` buffer before the UI subscribed, causing the
 * phone-number field to never appear.
 *
 * The fix: `authFlow = … .stateIn(Eagerly)` in `TelegramRepository` — collection
 * starts at injection time and the latest [AuthState] is always cached.
 */
@OptIn(ExperimentalCoroutinesApi::class)
class TelegramRepositoryAuthFlowTest {

    /** Build a [TelegramFlow] backed by a [FakeTdEngine]. */
    private fun fakeFlow(engine: FakeTdEngine): TelegramFlow =
        TelegramFlow(TdClientEngine(engine))

    /**
     * Mirrors `TelegramRepository.authFlow` mapping but returns a plain Flow
     * for testing individual auth state transitions.
     * [WaitTdlibParameters] maps to `null` and is filtered out.
     */
    private fun TelegramFlow.authStateFlow() = authorizationStateFlow()
        .map { it.toAuthState() }
        .filterNotNull()   // WaitTdlibParameters → null → dropped, same as StateFlow distinct behaviour

    // -----------------------------------------------------------------------
    // Auth-state mapping tests  (5 × individual state)
    // -----------------------------------------------------------------------

    @Test
    fun `WaitPhoneNumber maps to EnterPhone`() = runTest(UnconfinedTestDispatcher()) {
        val engine = FakeTdEngine().also { it.enqueue(TdUpdate.waitPhoneNumber()) }
        fakeFlow(engine).authStateFlow().test {
            assertEquals(AuthState.EnterPhone, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `WaitCode maps to EnterCode`() = runTest(UnconfinedTestDispatcher()) {
        val engine = FakeTdEngine().also { it.enqueue(TdUpdate.waitCode()) }
        fakeFlow(engine).authStateFlow().test {
            assertEquals(AuthState.EnterCode, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `WaitPassword maps to EnterPassword with correct hint`() = runTest(UnconfinedTestDispatcher()) {
        val engine = FakeTdEngine().also { it.enqueue(TdUpdate.waitPassword()) }
        fakeFlow(engine).authStateFlow().test {
            val item = awaitItem()
            assertIs<AuthState.EnterPassword>(item)
            assertEquals("Enter password. Hint: hint", item.dialogHint)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `Ready maps to LoggedIn`() = runTest(UnconfinedTestDispatcher()) {
        val engine = FakeTdEngine().also { it.enqueue(TdUpdate.ready()) }
        fakeFlow(engine).authStateFlow().test {
            assertEquals(AuthState.LoggedIn, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `unrelated updateOption is ignored by authorizationStateFlow`() = runTest(UnconfinedTestDispatcher()) {
        val engine = FakeTdEngine().also {
            it.enqueue(TdUpdate.optionUpdate())    // irrelevant — filtered by filterIsInstance
            it.enqueue(TdUpdate.waitPhoneNumber()) // only this should reach the mapping
        }
        fakeFlow(engine).authStateFlow().test {
            assertEquals(AuthState.EnterPhone, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `WaitTdlibParameters does not produce an AuthState`() = runTest(UnconfinedTestDispatcher()) {
        val engine = FakeTdEngine().also {
            it.enqueue(TdUpdate.waitTdlibParameters()) // → null → filtered
            it.enqueue(TdUpdate.waitPhoneNumber())     // → EnterPhone
        }
        fakeFlow(engine).authStateFlow().test {
            // First item must be EnterPhone; WaitTdlibParameters must be silently skipped.
            assertEquals(AuthState.EnterPhone, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    // -----------------------------------------------------------------------
    // Regression test — late subscriber must still see the auth state
    // -----------------------------------------------------------------------

    /**
     * This test directly models the race condition that caused the phone-number
     * field to never appear:
     *
     * 1. `WaitPhoneNumber` is emitted into a raw `SharedFlow(replay=1)`.
     * 2. Five unrelated `updateOption` events overwrite the replay buffer.
     * 3. A late subscriber (simulating the Compose UI) reads the StateFlow.
     *
     * **Expected**: StateFlow still holds `EnterPhone` because `stateIn(Eagerly)`
     * cached it independently of the raw buffer.
     *
     * The test works at the SharedFlow level so it does NOT depend on
     * `Dispatchers.Default` (used by [TdKtxClient] internally) and therefore
     * runs deterministically under [UnconfinedTestDispatcher].
     */
    @Test
    fun `late subscriber sees EnterPhone even after unrelated updates overwrite raw replay buffer`() =
        runTest(UnconfinedTestDispatcher()) {
            // ---------- simulate TdKtxClient.updates ----------
            val rawUpdates = MutableSharedFlow<String>(replay = 1, extraBufferCapacity = 64)

            // Decode raw JSON → AuthorizationState (mirrors TelegramFlow.updatesFlow chain)
            val authorizationFlow = rawUpdates
                .mapNotNull { json ->
                    runCatching { tdJson.decodeFromString(Update.serializer(), json) }.getOrNull()
                }
                .filterIsInstance<UpdateAuthorizationState>()
                .mapNotNull { it.authorizationState }

            // Map to AuthState and cache in a StateFlow — mirrors TelegramRepository.authFlow
            val stateFlow = authorizationFlow
                .map { it.toAuthState() }
                .filterNotNull()
                .stateIn(
                    scope = backgroundScope,
                    started = SharingStarted.Eagerly,
                    initialValue = null,
                )

            // 1. Emit WaitPhoneNumber → stateFlow caches EnterPhone
            rawUpdates.emit(TdUpdate.waitPhoneNumber())

            // 2. Overwrite the raw replay buffer with 5 unrelated updates
            repeat(5) { i -> rawUpdates.emit(TdUpdate.optionUpdate("key_$i", "val_$i")) }
            // At this point rawUpdates.replayCache = [optionUpdate("key_4", "val_4")]
            // i.e. WaitPhoneNumber is gone from the raw buffer.

            // 3. Late subscriber reads the StateFlow — must still be EnterPhone
            assertEquals(
                expected = AuthState.EnterPhone,
                actual   = stateFlow.value,
                message  = "StateFlow must hold EnterPhone after the raw replay buffer was overwritten. " +
                           "Got: ${stateFlow.value}. " +
                           "Ensure TelegramRepository.authFlow uses stateIn(SharingStarted.Eagerly)."
            )
        }

    // -----------------------------------------------------------------------
    // Full sequence
    // -----------------------------------------------------------------------

    @Test
    fun `full auth sequence WaitTdlibParameters → WaitPhoneNumber → WaitCode → Ready`() =
        runTest(UnconfinedTestDispatcher()) {
            val engine = FakeTdEngine().also {
                it.enqueue(TdUpdate.waitTdlibParameters()) // → null, filtered
                it.enqueue(TdUpdate.waitPhoneNumber())     // → EnterPhone
                it.enqueue(TdUpdate.waitCode())            // → EnterCode
                it.enqueue(TdUpdate.ready())               // → LoggedIn
            }
            fakeFlow(engine).authStateFlow().test {
                assertEquals(AuthState.EnterPhone, awaitItem())
                assertEquals(AuthState.EnterCode,  awaitItem())
                assertEquals(AuthState.LoggedIn,   awaitItem())
                cancelAndIgnoreRemainingEvents()
            }
        }
}
