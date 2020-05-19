---
title: ChatKtx.addRecentlyFound - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [addRecentlyFound](./add-recently-found.html)

# addRecentlyFound

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.addRecentlyFound(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds a chat to the list of recently found chats. The chat is added to
the beginning of the list. If the chat is already in the list, it will be removed from the list
first.

