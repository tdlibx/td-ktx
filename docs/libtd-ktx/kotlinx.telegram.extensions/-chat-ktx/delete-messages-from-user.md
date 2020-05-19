---
title: ChatKtx.deleteMessagesFromUser - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [deleteMessagesFromUser](./delete-messages-from-user.html)

# deleteMessagesFromUser

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.deleteMessagesFromUser(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes all messages sent by the specified user to a chat. Supported
only for supergroups; requires canDeleteMessages administrator privileges.

### Parameters

`userId` - User identifier.