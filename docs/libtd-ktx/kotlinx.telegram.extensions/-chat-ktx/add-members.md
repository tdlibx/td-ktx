---
title: ChatKtx.addMembers - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [addMembers](./add-members.html)

# addMembers

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.addMembers(userIds: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds multiple new members to a chat. Currently this option is only
available for supergroups and channels. This option can't be used to join a chat. Members can't be
added to a channel if it has more than 200 members. Members will not be added until the chat state
has been synchronized with the server.

### Parameters

`userIds` - Identifiers of the users to be added to the chat.