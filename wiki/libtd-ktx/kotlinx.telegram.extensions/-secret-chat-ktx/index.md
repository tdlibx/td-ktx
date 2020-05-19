[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [SecretChatKtx](./index.md)

# SecretChatKtx

`interface SecretChatKtx : `[`BaseKtx`](../-base-ktx/index.md)

Interface for access [TdApi.SecretChat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html) extension functions. Can be used alongside with other
extension interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) instance field to access its
functionality

### Properties

| Name | Summary |
|---|---|
| [api](api.md) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.md) |

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | Suspend function, which closes a secret chat, effectively transferring its state to secretChatStateClosed.`open suspend fun `[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html)`.close(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [create](create.md) | Suspend function, which returns an existing chat corresponding to a known secret chat.`open suspend fun `[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html)`.create(): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html) |
| [get](get.md) | Suspend function, which returns information about a secret chat by its identifier. This is an offline request.`open suspend fun `[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html)`.get(): `[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html) |

### Inheritors

| Name | Summary |
|---|---|
| [TelegramKtx](../-telegram-ktx/index.md) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](../-basic-group-ktx/index.md)`, `[`CallKtx`](../-call-ktx/index.md)`, `[`ChatKtx`](../-chat-ktx/index.md)`, `[`FileKtx`](../-file-ktx/index.md)`, `[`MessageKtx`](../-message-ktx/index.md)`, `[`NotificationGroupKtx`](../-notification-group-ktx/index.md)`, `[`ProxyKtx`](../-proxy-ktx/index.md)`, `[`SecretChatKtx`](./index.md)`, `[`SupergroupKtx`](../-supergroup-ktx/index.md)`, `[`UserKtx`](../-user-ktx/index.md)`, `[`CommonKtx`](../-common-ktx/index.md) |
