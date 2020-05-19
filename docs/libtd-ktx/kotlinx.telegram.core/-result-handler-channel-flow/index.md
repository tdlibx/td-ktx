---
title: ResultHandlerChannelFlow - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.core](../index.html) / [ResultHandlerChannelFlow](./index.html)

# ResultHandlerChannelFlow

`@ExperimentalCoroutinesApi class ResultHandlerChannelFlow : ResultHandlerFlow`

Class that converts results handler from [TdApi](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.html) client to [Flow](#)
of the [TdApi.Object](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html) using [ConflatedBroadcastChannel](#)

### Constructors

| [&lt;init&gt;](-init-.html) | Class that converts results handler from [TdApi](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.html) client to [Flow](#) of the [TdApi.Object](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html) using [ConflatedBroadcastChannel](#)`ResultHandlerChannelFlow(channel: BroadcastChannel<`[`Object`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html)`> = BroadcastChannel(Channel.CONFLATED))` |

### Functions

| [collect](collect.html) | `suspend fun collect(collector: FlowCollector<`[`Object`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onResult](on-result.html) | `fun onResult(result: `[`Object`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

