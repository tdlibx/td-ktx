---
title: editInlineMessageLiveLocation - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [editInlineMessageLiveLocation](./edit-inline-message-live-location.html)

# editInlineMessageLiveLocation

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.editInlineMessageLiveLocation(inlineMessageId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ReplyMarkup.html)`?, location: `[`Location`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Location.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which edits the content of a live location in an inline message sent via a bot;
for bots only.

### Parameters

`inlineMessageId` - Inline message identifier.

`replyMarkup` - The new message reply markup.

`location` - New location content of the message; may be null. Pass null to stop sharing the
live location.