[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [toggleChatIsMarkedAsUnread](./toggle-chat-is-marked-as-unread.md)

# toggleChatIsMarkedAsUnread

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.toggleChatIsMarkedAsUnread(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, isMarkedAsUnread: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the marked as unread state of a chat.

### Parameters

`chatId` - Chat identifier.

`isMarkedAsUnread` - New value of isMarkedAsUnread.