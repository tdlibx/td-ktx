---
title: setChatChatList - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setChatChatList](./set-chat-chat-list.html)

# setChatChatList

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setChatChatList(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, chatList: `[`ChatList`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatList.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which moves a chat to a different chat list. Current chat list of the chat must
ne non-null.

### Parameters

`chatId` - Chat identifier.

`chatList` - New chat list of the chat.