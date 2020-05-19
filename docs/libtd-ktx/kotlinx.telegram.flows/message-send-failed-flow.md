---
title: messageSendFailedFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [messageSendFailedFlow](./message-send-failed-flow.html)

# messageSendFailedFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.messageSendFailedFlow(): Flow<`[`UpdateMessageSendFailed`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateMessageSendFailed.html)`>`

emits [UpdateMessageSendFailed](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateMessageSendFailed.html) if a message failed to send. Be aware that some messages being
sent can be irrecoverably deleted, in which case updateDeleteMessages will be received instead of
this update.

