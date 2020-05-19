---
title: deleteChatMessagesFromUser - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [deleteChatMessagesFromUser](./delete-chat-messages-from-user.html)

# deleteChatMessagesFromUser

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.deleteChatMessagesFromUser(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes all messages sent by the specified user to a chat. Supported only
for supergroups; requires canDeleteMessages administrator privileges.

### Parameters

`chatId` - Chat identifier.

`userId` - User identifier.