[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [chatChatListFlow](./chat-chat-list-flow.md)

# chatChatListFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.chatChatListFlow(): Flow<`[`UpdateChatChatList`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatChatList.html)`>`

emits [UpdateChatChatList](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatChatList.html) if the list to which the chat belongs was changed. This update is
guaranteed to be sent only when chat.order == 0 and the current or the new chat list is null.

