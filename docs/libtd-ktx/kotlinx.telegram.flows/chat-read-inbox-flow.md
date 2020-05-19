---
title: chatReadInboxFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [chatReadInboxFlow](./chat-read-inbox-flow.html)

# chatReadInboxFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.chatReadInboxFlow(): Flow<`[`UpdateChatReadInbox`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatReadInbox.html)`>`

emits [UpdateChatReadInbox](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatReadInbox.html) if incoming messages were read or number of unread messages has been
changed.

