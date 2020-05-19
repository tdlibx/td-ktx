package kotlinx.telegram.core

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.asFlow
import org.drinkless.td.libcore.telegram.TdApi

/**
 * Class that converts results handler from [TdApi] client to [Flow]
 * of the [TdApi.Object] using [ConflatedBroadcastChannel]
 */
@ExperimentalCoroutinesApi
class ResultHandlerChannelFlow(
    private val channel: BroadcastChannel<TdApi.Object> = BroadcastChannel(Channel.CONFLATED)
) : TelegramFlow.ResultHandlerFlow {

    override fun onResult(result: TdApi.Object?) {
        if (!channel.isClosedForSend && result != null)
            channel.offer(result)
    }

    @FlowPreview
    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<TdApi.Object>) {
        channel.asFlow().collect(collector)
    }
}