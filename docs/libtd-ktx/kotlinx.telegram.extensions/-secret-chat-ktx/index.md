---
title: SecretChatKtx - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [SecretChatKtx](./index.html)

# SecretChatKtx

`interface SecretChatKtx : `[`BaseKtx`](../-base-ktx/index.html)

Interface for access [TdApi.SecretChat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SecretChat.html) extension functions. Can be used alongside with other
extension interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.html) instance field to access its
functionality

### Properties

| [api](api.html) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.html) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.html) |

### Functions

| [close](close.html) | Suspend function, which closes a secret chat, effectively transferring its state to secretChatStateClosed.`open suspend fun `[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SecretChat.html)`.close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [create](create.html) | Suspend function, which returns an existing chat corresponding to a known secret chat.`open suspend fun `[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SecretChat.html)`.create(): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html) |
| [get](get.html) | Suspend function, which returns information about a secret chat by its identifier. This is an offline request.`open suspend fun `[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SecretChat.html)`.get(): `[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SecretChat.html) |

### Inheritors

| [TelegramKtx](../-telegram-ktx/index.html) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](../-basic-group-ktx/index.html)`, `[`CallKtx`](../-call-ktx/index.html)`, `[`ChatKtx`](../-chat-ktx/index.html)`, `[`FileKtx`](../-file-ktx/index.html)`, `[`MessageKtx`](../-message-ktx/index.html)`, `[`NotificationGroupKtx`](../-notification-group-ktx/index.html)`, `[`ProxyKtx`](../-proxy-ktx/index.html)`, `[`SecretChatKtx`](./index.html)`, `[`SupergroupKtx`](../-supergroup-ktx/index.html)`, `[`UserKtx`](../-user-ktx/index.html)`, `[`CommonKtx`](../-common-ktx/index.html) |

