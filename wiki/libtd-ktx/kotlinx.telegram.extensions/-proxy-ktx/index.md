[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ProxyKtx](./index.md)

# ProxyKtx

`interface ProxyKtx : `[`BaseKtx`](../-base-ktx/index.md)

Interface for access [TdApi.Proxy](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Proxy.html) extension functions. Can be used alongside with other
extension interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) instance field to access its
functionality

### Properties

| [api](api.md) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.md) |

### Functions

| [edit](edit.md) | Suspend function, which edits an existing proxy server for network requests. Can be called before authorization.`open suspend fun `[`Proxy`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Proxy.html)`.edit(server: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, enable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, type: `[`ProxyType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ProxyType.html)`?): `[`Proxy`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Proxy.html) |
| [enable](enable.md) | Suspend function, which enables a proxy. Only one proxy can be enabled at a time. Can be called before authorization.`open suspend fun `[`Proxy`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Proxy.html)`.enable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getLink](get-link.md) | Suspend function, which returns an HTTPS link, which can be used to add a proxy. Available only for SOCKS5 and MTProto proxies. Can be called before authorization.`open suspend fun `[`Proxy`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Proxy.html)`.getLink(): `[`Text`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Text.html) |
| [ping](ping.md) | Suspend function, which computes time needed to receive a response from a Telegram server through a proxy. Can be called before authorization.`open suspend fun `[`Proxy`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Proxy.html)`.ping(): `[`Seconds`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Seconds.html) |
| [remove](remove.md) | Suspend function, which removes a proxy server. Can be called before authorization.`open suspend fun `[`Proxy`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Proxy.html)`.remove(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [TelegramKtx](../-telegram-ktx/index.md) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](../-basic-group-ktx/index.md)`, `[`CallKtx`](../-call-ktx/index.md)`, `[`ChatKtx`](../-chat-ktx/index.md)`, `[`FileKtx`](../-file-ktx/index.md)`, `[`MessageKtx`](../-message-ktx/index.md)`, `[`NotificationGroupKtx`](../-notification-group-ktx/index.md)`, `[`ProxyKtx`](./index.md)`, `[`SecretChatKtx`](../-secret-chat-ktx/index.md)`, `[`SupergroupKtx`](../-supergroup-ktx/index.md)`, `[`UserKtx`](../-user-ktx/index.md)`, `[`CommonKtx`](../-common-ktx/index.md) |

