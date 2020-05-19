[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [chatLastMessageFlow](./chat-last-message-flow.md)

# chatLastMessageFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.chatLastMessageFlow(): Flow<`[`UpdateChatLastMessage`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatLastMessage.html)`>`

emits [UpdateChatLastMessage](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatLastMessage.html) if the last message of a chat was changed. If lastMessage is null,
then the last message in the chat became unknown. Some new unknown messages might be added to the
chat in this case.

