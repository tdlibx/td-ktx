---
title: CallKtx - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [CallKtx](./index.html)

# CallKtx

`interface CallKtx : `[`BaseKtx`](../-base-ktx/index.html)

Interface for access [TdApi.Call](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Call.html) extension functions. Can be used alongside with other extension
interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.html) instance field to access its functionality

### Properties

| [api](api.html) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.html) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.html) |

### Functions

| [accept](accept.html) | Suspend function, which accepts an incoming call.`open suspend fun `[`Call`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Call.html)`.accept(protocol: `[`CallProtocol`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/CallProtocol.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [discard](discard.html) | Suspend function, which discards a call.`open suspend fun `[`Call`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Call.html)`.discard(isDisconnected: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, duration: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, connectionId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sendDebugInformation](send-debug-information.html) | Suspend function, which sends debug information for a call.`open suspend fun `[`Call`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Call.html)`.sendDebugInformation(debugInformation: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sendRating](send-rating.html) | Suspend function, which sends a call rating.`open suspend fun `[`Call`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Call.html)`.sendRating(rating: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, comment: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, problems: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`CallProblem`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/CallProblem.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [TelegramKtx](../-telegram-ktx/index.html) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](../-basic-group-ktx/index.html)`, `[`CallKtx`](./index.html)`, `[`ChatKtx`](../-chat-ktx/index.html)`, `[`FileKtx`](../-file-ktx/index.html)`, `[`MessageKtx`](../-message-ktx/index.html)`, `[`NotificationGroupKtx`](../-notification-group-ktx/index.html)`, `[`ProxyKtx`](../-proxy-ktx/index.html)`, `[`SecretChatKtx`](../-secret-chat-ktx/index.html)`, `[`SupergroupKtx`](../-supergroup-ktx/index.html)`, `[`UserKtx`](../-user-ktx/index.html)`, `[`CommonKtx`](../-common-ktx/index.html) |

