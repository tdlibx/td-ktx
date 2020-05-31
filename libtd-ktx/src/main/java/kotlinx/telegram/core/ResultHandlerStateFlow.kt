package kotlinx.telegram.core

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import org.drinkless.td.libcore.telegram.TdApi

/**
 * Class that converts results handler from [TdApi] client to [Flow]
 * of the [TdApi.Object] using [MutableStateFlow]
 */
@ExperimentalCoroutinesApi
class ResultHandlerStateFlow(
    private val stateFlow: MutableStateFlow<TdApi.Object?> = MutableStateFlow(null)
) : TelegramFlow.ResultHandlerFlow, Flow<TdApi.Object> by stateFlow.filterNotNull() {

    override fun onResult(result: TdApi.Object?) {
        stateFlow.value = result
    }
}