---
title: messageContentOpenedFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [messageContentOpenedFlow](./message-content-opened-flow.html)

# messageContentOpenedFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.messageContentOpenedFlow(): Flow<`[`UpdateMessageContentOpened`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateMessageContentOpened.html)`>`

emits [UpdateMessageContentOpened](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateMessageContentOpened.html) if the message content was opened. Updates voice note messages
to &amp;quot;listened&amp;quot;, video note messages to &amp;quot;viewed&amp;quot; and starts the TTL timer for
self-destructing messages.

