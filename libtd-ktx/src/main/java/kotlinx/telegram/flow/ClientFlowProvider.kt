package kotlinx.telegram.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import org.drinkless.td.libcore.telegram.Client
import org.drinkless.td.libcore.telegram.TdApi

class ClientFlowProvider(
    private val clientInstance: Client? = null
) : FlowProvider {

    val resultHandler = ResultHandlerFlow()
    
    private val client: Client = clientInstance
            ?.also { it.setUpdatesHandler { resultHandler } }
            ?: Client.create(resultHandler, null, null)


    override fun getFlow(): Flow<TdApi.Object> {
        return resultHandler.buffer(64)
    }

    override fun send(function: TdApi.Function, resultHandler: (TdApi.Object) -> Unit) {
        client.send(function, resultHandler)
    }

}

/**
 * Start a telegram flow for given [Client] to access it's functionality
 * For example:
 * ```
 * client.withFlow {
 *    TdApi.UpdateNewMessage().asFlow()
 *        .map { it.message }
 *        .onEach {
 *            TdApi.DeleteChatMessagesFromUser(it.chatId, it.senderUserId).launch()
 *        }.launchIn(scope)
 * }
 * ```
 * will delete all the incoming messages
 */
fun Client.withFlow(function: TelegramFlow.() -> Unit) {
    val provider = ClientFlowProvider(this)
    val telegramFlow = TelegramFlow(provider)
    function(telegramFlow)
}