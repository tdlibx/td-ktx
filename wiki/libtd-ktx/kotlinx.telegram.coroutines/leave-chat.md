[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [leaveChat](./leave-chat.md)

# leaveChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.leaveChat(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes current user from chat members. Private and secret chats can't be
left using this method.

### Parameters

`chatId` - Chat identifier.