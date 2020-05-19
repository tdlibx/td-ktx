[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [deleteHistory](./delete-history.md)

# deleteHistory

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.deleteHistory(removeFromChatList: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, revoke: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes all messages in the chat. Use Chat.canBeDeletedOnlyForSelf and
Chat.canBeDeletedForAllUsers fields to find whether and how the method can be applied to the chat.

### Parameters

`removeFromChatList` - Pass true if the chat should be removed from the chat list.

`revoke` - Pass true to try to delete chat history for all users.