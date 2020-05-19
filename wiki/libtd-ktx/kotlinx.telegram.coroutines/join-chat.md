[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [joinChat](./join-chat.md)

# joinChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.joinChat(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds current user as a new member to a chat. Private and secret chats
can't be joined using this method.

### Parameters

`chatId` - Chat identifier.