[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [UserKtx](index.md) / [setChatMemberStatus](./set-chat-member-status.md)

# setChatMemberStatus

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.User.html)`.setChatMemberStatus(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, status: `[`ChatMemberStatus`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatMemberStatus.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the status of a chat member, needs appropriate privileges. This
function is currently not suitable for adding new members to the chat and transferring chat
ownership; instead, use addChatMember or transferChatOwnership. The chat member status will not be
changed until it has been synchronized with the server.

### Parameters

`chatId` - Chat identifier.

`status` - The new status of the member in the chat.