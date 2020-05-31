---
title: UserKtx.addChatMember - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [UserKtx](index.html) / [addChatMember](./add-chat-member.html)

# addChatMember

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.User.html)`.addChatMember(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, forwardLimit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds a new member to a chat. Members can't be added to private or
secret chats. Members will not be added until the chat state has been synchronized with the
server.

### Parameters

`chatId` - Chat identifier.

`forwardLimit` - The number of earlier messages from the chat to be forwarded to the new
member; up to 100. Ignored for supergroups and channels.