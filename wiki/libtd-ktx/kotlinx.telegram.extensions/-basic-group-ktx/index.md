[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [BasicGroupKtx](./index.md)

# BasicGroupKtx

`interface BasicGroupKtx : `[`BaseKtx`](../-base-ktx/index.md)

Interface for access [TdApi.BasicGroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html) extension functions. Can be used alongside with other
extension interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) instance field to access its
functionality

### Properties

| Name | Summary |
|---|---|
| [api](api.md) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.md) |

### Functions

| Name | Summary |
|---|---|
| [createChat](create-chat.md) | Suspend function, which returns an existing chat corresponding to a known basic group.`open suspend fun `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html)`.createChat(force: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html) |
| [get](get.md) | Suspend function, which returns information about a basic group by its identifier. This is an offline request if the current user is not a bot.`open suspend fun `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html)`.get(): `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html) |
| [getFullInfo](get-full-info.md) | Suspend function, which returns full information about a basic group by its identifier.`open suspend fun `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html)`.getFullInfo(): `[`BasicGroupFullInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroupFullInfo.html) |

### Inheritors

| Name | Summary |
|---|---|
| [TelegramKtx](../-telegram-ktx/index.md) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](./index.md)`, `[`CallKtx`](../-call-ktx/index.md)`, `[`ChatKtx`](../-chat-ktx/index.md)`, `[`FileKtx`](../-file-ktx/index.md)`, `[`MessageKtx`](../-message-ktx/index.md)`, `[`NotificationGroupKtx`](../-notification-group-ktx/index.md)`, `[`ProxyKtx`](../-proxy-ktx/index.md)`, `[`SecretChatKtx`](../-secret-chat-ktx/index.md)`, `[`SupergroupKtx`](../-supergroup-ktx/index.md)`, `[`UserKtx`](../-user-ktx/index.md)`, `[`CommonKtx`](../-common-ktx/index.md) |
