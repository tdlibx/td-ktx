[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [newChatFlow](./new-chat-flow.md)

# newChatFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.newChatFlow(): Flow<`[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`>`

emits [Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html) if a new chat has been loaded/created. This update is guaranteed to come before the
chat identifier is returned to the client. The chat field changes will be reported through separate
updates.

