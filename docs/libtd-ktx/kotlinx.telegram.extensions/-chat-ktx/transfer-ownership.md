---
title: ChatKtx.transferOwnership - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [transferOwnership](./transfer-ownership.html)

# transferOwnership

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.transferOwnership(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the owner of a chat. The current user must be a current owner
of the chat. Use the method canTransferOwnership to check whether the ownership can be transferred
from the current session. Available only for supergroups and channel chats.

### Parameters

`userId` - Identifier of the user to which transfer the ownership. The ownership can't be
transferred to a bot or to a deleted user.

`password` - The password of the current user.