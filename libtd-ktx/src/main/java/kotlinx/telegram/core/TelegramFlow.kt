/*
package kotlinx.telegram.core

import android.util.Log
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.transform
import kotlinx.telegram.flow.ClientFlowProvider
import org.drinkless.td.libcore.telegram.Client
import org.drinkless.td.libcore.telegram.TdApi
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

interface FlowProvider {
    fun getFlow(): Flow<TdApi.Object>
    fun send(function: TdApi.Function, resultHandler: (TdApi.Object) -> Unit)
    fun createClient()
}

private fun <T> Client.sendAsync(testProxy: TdApi.Function): T {
    TODO("Not yet implemented")
}

@ExperimentalCoroutinesApi
open class TelegramFlow(
    val flowProvider: FlowProvider = ClientFlowProvider()
) {

    val mainFlow: Flow<TdApi.Object> = flowProvider.getFlow()

    fun createClient() {
        flowProvider.createClient()
    }

    suspend fun createClientWithParameters(parameters: TdApi.TdlibParameters, key: ByteArray?) {
        flowProvider.createClient()
        TdApi.SetTdlibParameters(parameters).launch()
        TdApi.CheckDatabaseEncryptionKey(key).launch()
    }

    // transform

    inline fun <reified UpdateType : TdApi.Update> UpdateType.asFlow(): Flow<UpdateType> =
        mainFlow.filterIsInstance<UpdateType>()

    inline fun <reified UpdateType : TdApi.Update, ResultType>
        UpdateType.mapAsFlow(crossinline block: suspend (UpdateType) -> ResultType): Flow<ResultType> =
        mainFlow.transform { value ->
            if (value is UpdateType) emit(block(value))
        }


    //live data

//    inline fun <reified UpdateType : TdApi.Update, LiveDataType>
//        UpdateType.mapAsLiveData(crossinline block: (UpdateType) -> LiveDataType) =
//        this.mapAsFlow { block(this) }.asLiveData()
//    fun <LiveDataType : TdApi.Object> Flow<LiveDataType>.asLiveData() =
//        liveData {
//            collect { emit(it) }
//        }

    //launchers


    @Throws(TelegramException::class)
    suspend inline fun <reified ExpectedResult : TdApi.Object>
        TdApi.Function.expect(
        resultFunc: (ExpectedResult) -> Unit = {}
    ) = resultFunc(
        suspendCoroutine { cont ->
            flowProvider.send(this) {
                when (it) {
                    is ExpectedResult -> cont.resume(it)
                    is TdApi.Error -> cont.resumeWithException(TelegramException.Error(it.message))
                    else -> cont.resumeWithException(TelegramException.UnexpectedResult(it))
                }
            }
        }
    )

    suspend inline fun <reified ExpectedResult : TdApi.Object>
        TdApi.Function.async() : ExpectedResult = suspendCoroutine { cont ->
            flowProvider.send(this) {
                when (it) {
                    is ExpectedResult -> cont.resume(it)
                    is TdApi.Error -> cont.resumeWithException(Exception(it.message))
                    else -> cont.resumeWithException(Exception("unexpected result $it"))
                }
            }
        }

    suspend inline fun TdApi.Function.launch() = suspendCoroutine<Boolean> { cont ->
        flowProvider.send(this) {
            when (it) {
                is TdApi.Ok -> {
                    "$this returns true".log()
                    cont.resume(true)
                }

                is TdApi.Error -> cont.resume(false)
                else -> cont.resumeWithException(Exception("unexpected result $it"))
            }
        }
    }
}

fun String.log() {
    Log.e("=========", this)
}

*/
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
 *//*

fun Client.withFlow(function: TelegramFlow.() -> Unit) {
    val provider = ClientFlowProvider(this)
    val telegramFlow = TelegramFlow(provider)
    function(telegramFlow)
}*/
