---
title: messageLiveLocationViewedFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [messageLiveLocationViewedFlow](./message-live-location-viewed-flow.html)

# messageLiveLocationViewedFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.messageLiveLocationViewedFlow(): Flow<`[`UpdateMessageLiveLocationViewed`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateMessageLiveLocationViewed.html)`>`

emits [UpdateMessageLiveLocationViewed](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateMessageLiveLocationViewed.html) if a message with a live location was viewed. When the
update is received, the client is supposed to update the live location.

