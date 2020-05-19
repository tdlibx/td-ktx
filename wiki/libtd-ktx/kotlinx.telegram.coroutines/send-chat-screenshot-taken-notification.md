[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [sendChatScreenshotTakenNotification](./send-chat-screenshot-taken-notification.md)

# sendChatScreenshotTakenNotification

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.sendChatScreenshotTakenNotification(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sends a notification about a screenshot taken in a chat. Supported only
in private and secret chats.

### Parameters

`chatId` - Chat identifier.