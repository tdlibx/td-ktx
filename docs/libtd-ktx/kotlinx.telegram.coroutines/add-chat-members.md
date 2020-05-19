---
title: addChatMembers - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [addChatMembers](./add-chat-members.html)

# addChatMembers

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.addChatMembers(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userIds: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds multiple new members to a chat. Currently this option is only
available for supergroups and channels. This option can't be used to join a chat. Members can't be
added to a channel if it has more than 200 members. Members will not be added until the chat state
has been synchronized with the server.

### Parameters

`chatId` - Chat identifier.

`userIds` - Identifiers of the users to be added to the chat.