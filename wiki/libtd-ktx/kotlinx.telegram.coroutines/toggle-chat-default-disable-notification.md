[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [toggleChatDefaultDisableNotification](./toggle-chat-default-disable-notification.md)

# toggleChatDefaultDisableNotification

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.toggleChatDefaultDisableNotification(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, defaultDisableNotification: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the value of the default disableNotification parameter, used when
a message is sent to a chat.

### Parameters

`chatId` - Chat identifier.

`defaultDisableNotification` - New value of defaultDisableNotification.