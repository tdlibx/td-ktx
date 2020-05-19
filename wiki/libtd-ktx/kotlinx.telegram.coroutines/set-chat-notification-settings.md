[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setChatNotificationSettings](./set-chat-notification-settings.md)

# setChatNotificationSettings

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setChatNotificationSettings(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, notificationSettings: `[`ChatNotificationSettings`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatNotificationSettings.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the notification settings of a chat. Notification settings of a
chat with the current user (Saved Messages) can't be changed.

### Parameters

`chatId` - Chat identifier.

`notificationSettings` - New notification settings for the chat. If the chat is muted for more
than 1 week, it is considered to be muted forever.