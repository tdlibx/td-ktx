[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [setNotificationSettings](./set-notification-settings.md)

# setNotificationSettings

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.setNotificationSettings(notificationSettings: `[`ChatNotificationSettings`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatNotificationSettings.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the notification settings of a chat. Notification settings of a
chat with the current user (Saved Messages) can't be changed.

### Parameters

`notificationSettings` - New notification settings for the chat. If the chat is muted for
more than 1 week, it is considered to be muted forever.