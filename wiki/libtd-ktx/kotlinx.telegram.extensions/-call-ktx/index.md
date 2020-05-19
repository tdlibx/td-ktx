[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [CallKtx](./index.md)

# CallKtx

`interface CallKtx : `[`BaseKtx`](../-base-ktx/index.md)

Interface for access [TdApi.Call](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Call.html) extension functions. Can be used alongside with other extension
interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) instance field to access its functionality

### Properties

| [api](api.md) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.md) |

### Functions

| [accept](accept.md) | Suspend function, which accepts an incoming call.`open suspend fun `[`Call`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Call.html)`.accept(protocol: `[`CallProtocol`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallProtocol.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [discard](discard.md) | Suspend function, which discards a call.`open suspend fun `[`Call`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Call.html)`.discard(isDisconnected: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, duration: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, connectionId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sendDebugInformation](send-debug-information.md) | Suspend function, which sends debug information for a call.`open suspend fun `[`Call`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Call.html)`.sendDebugInformation(debugInformation: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sendRating](send-rating.md) | Suspend function, which sends a call rating.`open suspend fun `[`Call`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Call.html)`.sendRating(rating: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, comment: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, problems: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`CallProblem`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallProblem.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [TelegramKtx](../-telegram-ktx/index.md) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](../-basic-group-ktx/index.md)`, `[`CallKtx`](./index.md)`, `[`ChatKtx`](../-chat-ktx/index.md)`, `[`FileKtx`](../-file-ktx/index.md)`, `[`MessageKtx`](../-message-ktx/index.md)`, `[`NotificationGroupKtx`](../-notification-group-ktx/index.md)`, `[`ProxyKtx`](../-proxy-ktx/index.md)`, `[`SecretChatKtx`](../-secret-chat-ktx/index.md)`, `[`SupergroupKtx`](../-supergroup-ktx/index.md)`, `[`UserKtx`](../-user-ktx/index.md)`, `[`CommonKtx`](../-common-ktx/index.md) |

