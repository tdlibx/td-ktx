---
title: messageEditedFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [messageEditedFlow](./message-edited-flow.html)

# messageEditedFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.messageEditedFlow(): Flow<`[`UpdateMessageEdited`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateMessageEdited.html)`>`

emits [UpdateMessageEdited](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateMessageEdited.html) if a message was edited. Changes in the message content will come in
a separate updateMessageContent.

