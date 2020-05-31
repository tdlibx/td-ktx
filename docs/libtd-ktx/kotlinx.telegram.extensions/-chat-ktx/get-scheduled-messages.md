---
title: ChatKtx.getScheduledMessages - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [getScheduledMessages](./get-scheduled-messages.html)

# getScheduledMessages

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.getScheduledMessages(): `[`Messages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Messages.html)

Suspend function, which returns all scheduled messages in a chat. The messages are returned in
a reverse chronological order (i.e., in order of decreasing messageId).

**Return**
[TdApi.Messages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Messages.html) Contains a list of messages.

