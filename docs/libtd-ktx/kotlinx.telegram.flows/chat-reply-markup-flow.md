---
title: chatReplyMarkupFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [chatReplyMarkupFlow](./chat-reply-markup-flow.html)

# chatReplyMarkupFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.chatReplyMarkupFlow(): Flow<`[`UpdateChatReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateChatReplyMarkup.html)`>`

emits [UpdateChatReplyMarkup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateChatReplyMarkup.html) if the default chat reply markup was changed. Can occur because new
messages with reply markup were received or because an old reply markup was hidden by the user.

