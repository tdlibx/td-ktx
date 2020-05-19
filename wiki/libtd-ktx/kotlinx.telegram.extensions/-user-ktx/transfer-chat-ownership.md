[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [UserKtx](index.md) / [transferChatOwnership](./transfer-chat-ownership.md)

# transferChatOwnership

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html)`.transferChatOwnership(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the owner of a chat. The current user must be a current owner
of the chat. Use the method canTransferOwnership to check whether the ownership can be transferred
from the current session. Available only for supergroups and channel chats.

### Parameters

`chatId` - Chat identifier.

`password` - The password of the current user.