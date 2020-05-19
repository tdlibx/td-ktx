[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [chatReplyMarkupFlow](./chat-reply-markup-flow.md)

# chatReplyMarkupFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.chatReplyMarkupFlow(): Flow<`[`UpdateChatReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatReplyMarkup.html)`>`

emits [UpdateChatReplyMarkup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatReplyMarkup.html) if the default chat reply markup was changed. Can occur because new
messages with reply markup were received or because an old reply markup was hidden by the user.

