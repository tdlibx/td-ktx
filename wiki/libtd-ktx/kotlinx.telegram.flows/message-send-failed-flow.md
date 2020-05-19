[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [messageSendFailedFlow](./message-send-failed-flow.md)

# messageSendFailedFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.messageSendFailedFlow(): Flow<`[`UpdateMessageSendFailed`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateMessageSendFailed.html)`>`

emits [UpdateMessageSendFailed](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateMessageSendFailed.html) if a message failed to send. Be aware that some messages being
sent can be irrecoverably deleted, in which case updateDeleteMessages will be received instead of
this update.

