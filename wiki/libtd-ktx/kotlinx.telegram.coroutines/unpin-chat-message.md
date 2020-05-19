[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [unpinChatMessage](./unpin-chat-message.md)

# unpinChatMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.unpinChatMessage(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes the pinned message from a chat; requires canPinMessages rights in
the group or channel.

### Parameters

`chatId` - Identifier of the chat.