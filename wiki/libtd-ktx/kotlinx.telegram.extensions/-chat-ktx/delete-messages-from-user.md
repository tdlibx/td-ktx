[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [deleteMessagesFromUser](./delete-messages-from-user.md)

# deleteMessagesFromUser

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.deleteMessagesFromUser(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes all messages sent by the specified user to a chat. Supported
only for supergroups; requires canDeleteMessages administrator privileges.

### Parameters

`userId` - User identifier.