[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [deleteMessages](./delete-messages.md)

# deleteMessages

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.deleteMessages(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?, revoke: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes messages.

### Parameters

`chatId` - Chat identifier.

`messageIds` - Identifiers of the messages to be deleted.

`revoke` - Pass true to try to delete messages for all chat members. Always true for
supergroups, channels and secret chats.