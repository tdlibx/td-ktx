package kotlinx.telegram.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.asFlow
import org.drinkless.td.libcore.telegram.Client
import org.drinkless.td.libcore.telegram.TdApi

@ExperimentalCoroutinesApi
class ResultHandlerFlow(
    val channel: BroadcastChannel<TdApi.Object> = BroadcastChannel(Channel.CONFLATED)
) : Client.ResultHandler, Client.ExceptionHandler, Flow<TdApi.Object> {


    override fun onResult(result: TdApi.Object?) {
        if (!channel.isClosedForSend && result != null)
            channel.offer(result)
    }

    override fun onException(throwable: Throwable?) {
        if (!channel.isClosedForSend && throwable != null)
            channel.offer(TdApi.Error(42, throwable.message))
    }

    @FlowPreview
    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<TdApi.Object>) {
        channel.asFlow().collect(collector)
    }
}