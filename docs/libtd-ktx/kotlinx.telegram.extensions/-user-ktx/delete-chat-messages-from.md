---
title: UserKtx.deleteChatMessagesFrom - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [UserKtx](index.html) / [deleteChatMessagesFrom](./delete-chat-messages-from.html)

# deleteChatMessagesFrom

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html)`.deleteChatMessagesFrom(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes all messages sent by the specified user to a chat. Supported
only for supergroups; requires canDeleteMessages administrator privileges.

### Parameters

`chatId` - Chat identifier.