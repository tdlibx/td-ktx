---
title: ChatKtx.addMember - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [addMember](./add-member.html)

# addMember

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.addMember(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, forwardLimit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds a new member to a chat. Members can't be added to private or
secret chats. Members will not be added until the chat state has been synchronized with the
server.

### Parameters

`userId` - Identifier of the user.

`forwardLimit` - The number of earlier messages from the chat to be forwarded to the new
member; up to 100. Ignored for supergroups and channels.