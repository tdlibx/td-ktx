package kotlinx.telegram.core

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import org.drinkless.td.libcore.telegram.Client
import org.drinkless.td.libcore.telegram.TdApi
import java.io.Closeable
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Main class to interact with Telegram API client
 */
class TelegramFlow(
    val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val flowScope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
) : Closeable {

    /**
     * Telegram [Client] instance. Null if instance is not attached
     */
    var client: Client? = null

    /**
     * The base Telegram API Flow
     */
    lateinit var updateEventsFlow: Flow<TdApi.Object>

    /**
     * Attach instance to the existing native Telegram client or create one
     * @param existingClient set an existing client to attach, null by default
     */
    @ExperimentalCoroutinesApi
    fun attachClient(
        existingClient: Client? = null
    ) {
        if (client != null) return // client is already attached

        updateEventsFlow = callbackFlow {
            val resultHandler = Client.ResultHandler { trySend(it) }

            client = existingClient
                ?.also { it.setUpdatesHandler(resultHandler) }
                ?: Client.create(
                    resultHandler,
                    null,
                    null
                )

            awaitClose {
                client?.setUpdatesHandler(null)
            }
        }
            .shareIn(
                scope = flowScope,
                replay = 1,
                started = SharingStarted.Eagerly
            )
    }

    /**
     * Return data flow from Telegram API of the given type [T]
     */
    inline fun <reified T : TdApi.Object> getUpdatesFlowOfType() =
        updateEventsFlow
            .filterIsInstance<T>()

    /**
     * Sends a request to the TDLib and expect a result.
     *
     * @param function [TdApi.Function] representing a TDLib interface function-class.
     * @param ExpectedResult result type expecting from given [function].
     * @throws TelegramException.Error if TdApi request returns an exception
     * @throws TelegramException.UnexpectedResult if TdApi request returns an unexpected result
     * @throws TelegramException.ClientNotAttached if TdApi client has not attached yet
     */
    suspend inline fun <reified ExpectedResult : TdApi.Object> sendFunctionAsync(function: TdApi.Function): ExpectedResult =
        withContext(coroutineDispatcher) {
            suspendCancellableCoroutine { continuation ->
                val resultHandler: (TdApi.Object) -> Unit = { result ->
                    when (result) {
                        is ExpectedResult -> continuation.resume(result)
                        is TdApi.Error -> continuation.resumeWithException(
                            TelegramException.Error(result.message, result.code)
                        )
                        else -> continuation.resumeWithException(
                            TelegramException.UnexpectedResult(result)
                        )
                    }
                }
                client?.send(function, resultHandler) { throwable ->
                    continuation.resumeWithException(
                        TelegramException.Error(throwable?.message ?: "unknown")
                    )
                } ?: throw TelegramException.ClientNotAttached
            }
        }

    /**
     * Sends a request to the TDLib and expect [TdApi.Ok]
     *
     * @param function [TdApi.Function] representing a TDLib interface function-class.
     * @throws TelegramException.Error if TdApi request returns an exception
     * @throws TelegramException.UnexpectedResult if TdApi request returns an unexpected result
     * @throws TelegramException.ClientNotAttached if TdApi client has not attached yet
     */
    suspend fun sendFunctionLaunch(function: TdApi.Function) {
        sendFunctionAsync<TdApi.Ok>(function)
    }

    /**
     * Closes Client.
     */
    override fun close() {
        client?.close()
    }
}