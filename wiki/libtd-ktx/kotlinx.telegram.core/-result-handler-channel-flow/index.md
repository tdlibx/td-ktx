[libtd-ktx](../../index.md) / [kotlinx.telegram.core](../index.md) / [ResultHandlerChannelFlow](./index.md)

# ResultHandlerChannelFlow

`@ExperimentalCoroutinesApi class ResultHandlerChannelFlow : ResultHandlerFlow`

Class that converts results handler from [TdApi](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.html) client to [Flow](#)
of the [TdApi.Object](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html) using [ConflatedBroadcastChannel](#)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | Class that converts results handler from [TdApi](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.html) client to [Flow](#) of the [TdApi.Object](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html) using [ConflatedBroadcastChannel](#)`ResultHandlerChannelFlow(channel: BroadcastChannel<`[`Object`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html)`> = BroadcastChannel(Channel.CONFLATED))` |

### Functions

| Name | Summary |
|---|---|
| [collect](collect.md) | `suspend fun collect(collector: FlowCollector<`[`Object`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onResult](on-result.md) | `fun onResult(result: `[`Object`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
