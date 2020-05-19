[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [messageLiveLocationViewedFlow](./message-live-location-viewed-flow.md)

# messageLiveLocationViewedFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.messageLiveLocationViewedFlow(): Flow<`[`UpdateMessageLiveLocationViewed`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateMessageLiveLocationViewed.html)`>`

emits [UpdateMessageLiveLocationViewed](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateMessageLiveLocationViewed.html) if a message with a live location was viewed. When the
update is received, the client is supposed to update the live location.

