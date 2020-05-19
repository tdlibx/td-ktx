[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [addRecentlyFoundChat](./add-recently-found-chat.md)

# addRecentlyFoundChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.addRecentlyFoundChat(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds a chat to the list of recently found chats. The chat is added to the
beginning of the list. If the chat is already in the list, it will be removed from the list first.

### Parameters

`chatId` - Identifier of the chat to add.