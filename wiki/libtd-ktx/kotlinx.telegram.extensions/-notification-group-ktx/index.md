[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [NotificationGroupKtx](./index.md)

# NotificationGroupKtx

`interface NotificationGroupKtx : `[`BaseKtx`](../-base-ktx/index.md)

Interface for access [TdApi.NotificationGroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/NotificationGroup.html) extension functions. Can be used alongside with
other extension interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) instance field to access its
functionality

### Properties

| Name | Summary |
|---|---|
| [api](api.md) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.md) |

### Functions

| Name | Summary |
|---|---|
| [remove](remove.md) | Suspend function, which removes a group of active notifications. Needs to be called only if the notification group is removed by the current user.`open suspend fun `[`NotificationGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/NotificationGroup.html)`.remove(maxNotificationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeNotification](remove-notification.md) | Suspend function, which removes an active notification from notification list. Needs to be called only if the notification is removed by the current user.`open suspend fun `[`NotificationGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/NotificationGroup.html)`.removeNotification(notificationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [TelegramKtx](../-telegram-ktx/index.md) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](../-basic-group-ktx/index.md)`, `[`CallKtx`](../-call-ktx/index.md)`, `[`ChatKtx`](../-chat-ktx/index.md)`, `[`FileKtx`](../-file-ktx/index.md)`, `[`MessageKtx`](../-message-ktx/index.md)`, `[`NotificationGroupKtx`](./index.md)`, `[`ProxyKtx`](../-proxy-ktx/index.md)`, `[`SecretChatKtx`](../-secret-chat-ktx/index.md)`, `[`SupergroupKtx`](../-supergroup-ktx/index.md)`, `[`UserKtx`](../-user-ktx/index.md)`, `[`CommonKtx`](../-common-ktx/index.md) |
