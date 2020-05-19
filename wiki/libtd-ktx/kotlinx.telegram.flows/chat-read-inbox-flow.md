[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [chatReadInboxFlow](./chat-read-inbox-flow.md)

# chatReadInboxFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.chatReadInboxFlow(): Flow<`[`UpdateChatReadInbox`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateChatReadInbox.html)`>`

emits [UpdateChatReadInbox](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateChatReadInbox.html) if incoming messages were read or number of unread messages has been
changed.

