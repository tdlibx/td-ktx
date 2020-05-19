[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [addChatMember](./add-chat-member.md)

# addChatMember

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.addChatMember(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, forwardLimit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds a new member to a chat. Members can't be added to private or secret
chats. Members will not be added until the chat state has been synchronized with the server.

### Parameters

`chatId` - Chat identifier.

`userId` - Identifier of the user.

`forwardLimit` - The number of earlier messages from the chat to be forwarded to the new
member; up to 100. Ignored for supergroups and channels.