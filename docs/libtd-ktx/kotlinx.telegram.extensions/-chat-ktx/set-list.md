---
title: ChatKtx.setList - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [setList](./set-list.html)

# setList

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.setList(chatList: `[`ChatList`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatList.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which moves a chat to a different chat list. Current chat list of the chat
must ne non-null.

### Parameters

`chatList` - New chat list of the chat.