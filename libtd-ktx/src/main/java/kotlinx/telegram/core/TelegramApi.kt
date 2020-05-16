package kotlinx.telegram.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.filterIsInstance
import org.drinkless.td.libcore.telegram.Client
import org.drinkless.td.libcore.telegram.TdApi
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class TelegramApi(
    private val resultHandler: ResultHandlerChannelFlow = ResultHandlerChannelFlow(),
    private val existingClient: Client? = null
) {

    var client: Client? = null

    fun attachClient() {
        if (client != null) return // client is already attached

        client = existingClient
            ?.also { it.setUpdatesHandler { resultHandler } }
            ?: Client.create(
                resultHandler,
                null,
                null
            )
    }

    fun getUpdatesFlow(): Flow<TdApi.Object> = resultHandler.buffer(64)

    inline fun <reified T : TdApi.Object> getUpdatesFlowOfType() =
        getUpdatesFlow().filterIsInstance<T>()

    fun send(
        function: TdApi.Function,
        resultHandler: (TdApi.Object) -> Unit,
        exceptionHandler: (Throwable?) -> Unit
    ) {
        client?.send(function, resultHandler, exceptionHandler)
            ?: throw TelegramException.ClientNotAttached
    }

    /**
     * Sends a request to the TDLib and expect a result.
     *
     * @param function [TdApi.Function] representing a TDLib interface function-class.
     * @param ExpectedResult result type expecting from given [function].
     * @throws TelegramException.Error if TdApi request returns an exception
     * @throws TelegramException.UnexpectedResult if TdApi request returns an unexpected result
     * @throws TelegramException.ClientNotAttached if TdApi client has not attached yet
     */
    suspend inline fun <reified ExpectedResult : TdApi.Object>
        sendFunctionAsync(function: TdApi.Function): ExpectedResult =
        suspendCoroutine { cont ->
            send(
                function,
                { result ->
                    when (result) {
                        is ExpectedResult -> cont.resume(result)
                        is TdApi.Error -> cont.resumeWithException(
                            TelegramException.Error(result.message)
                        )
                        else -> cont.resumeWithException(
                            TelegramException.UnexpectedResult(
                                result
                            )
                        )
                    }
                },
                { throwable ->
                    cont.resumeWithException(
                        TelegramException.Error(
                            throwable?.message ?: "unknown"
                        )
                    )
                }
            )
        }

    /**
     * Sends a request to the TDLib. Ignore function result
     *
     * @param function [TdApi.Function] representing a TDLib interface function-class.
     * @throws TelegramException.Error if TdApi request returns an exception
     * @throws TelegramException.UnexpectedResult if TdApi request returns an unexpected result
     * @throws TelegramException.ClientNotAttached if TdApi client has not attached yet
     */
    suspend fun sendFunctionLaunch(function: TdApi.Function) {
        sendFunctionAsync<TdApi.Ok>(function)
    }
}