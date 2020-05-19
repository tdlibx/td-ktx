---
title: ChatKtx.open - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [open](./open.html)

# open

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.open(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs TDLib that the chat is opened by the user. Many useful
activities depend on the chat being opened or closed (e.g., in supergroups and channels all
updates are received only for opened chats).

