---
title: ChatKtx.deleteMessages - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [deleteMessages](./delete-messages.html)

# deleteMessages

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.deleteMessages(messageIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?, revoke: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes messages.

### Parameters

`messageIds` - Identifiers of the messages to be deleted.

`revoke` - Pass true to try to delete messages for all chat members. Always true for
supergroups, channels and secret chats.