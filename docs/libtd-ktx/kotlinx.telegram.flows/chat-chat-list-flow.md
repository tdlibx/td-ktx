---
title: chatChatListFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [chatChatListFlow](./chat-chat-list-flow.html)

# chatChatListFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.chatChatListFlow(): Flow<`[`UpdateChatChatList`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatChatList.html)`>`

emits [UpdateChatChatList](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatChatList.html) if the list to which the chat belongs was changed. This update is
guaranteed to be sent only when chat.order == 0 and the current or the new chat list is null.

