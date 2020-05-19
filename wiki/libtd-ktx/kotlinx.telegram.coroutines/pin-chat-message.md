[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [pinChatMessage](./pin-chat-message.md)

# pinChatMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.pinChatMessage(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, disableNotification: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which pins a message in a chat; requires canPinMessages rights.

### Parameters

`chatId` - Identifier of the chat.

`messageId` - Identifier of the new pinned message.

`disableNotification` - True, if there should be no notification about the pinned message.