[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [messageEditedFlow](./message-edited-flow.md)

# messageEditedFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.messageEditedFlow(): Flow<`[`UpdateMessageEdited`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateMessageEdited.html)`>`

emits [UpdateMessageEdited](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateMessageEdited.html) if a message was edited. Changes in the message content will come in
a separate updateMessageContent.

