---
title: setChatMemberStatus - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setChatMemberStatus](./set-chat-member-status.html)

# setChatMemberStatus

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setChatMemberStatus(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, status: `[`ChatMemberStatus`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatMemberStatus.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the status of a chat member, needs appropriate privileges. This
function is currently not suitable for adding new members to the chat and transferring chat
ownership; instead, use addChatMember or transferChatOwnership. The chat member status will not be
changed until it has been synchronized with the server.

### Parameters

`chatId` - Chat identifier.

`userId` - User identifier.

`status` - The new status of the member in the chat.