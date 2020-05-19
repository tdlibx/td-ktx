---
title: MessageKtx.editLiveLocation - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [MessageKtx](index.html) / [editLiveLocation](./edit-live-location.html)

# editLiveLocation

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.editLiveLocation(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ReplyMarkup.html)`?, location: `[`Location`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Location.html)`? = null): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)

Suspend function, which edits the message content of a live location. Messages can be edited
for a limited period of time specified in the live location. Returns the edited message after the
edit is completed on the server side.

### Parameters

`chatId` - The chat the message belongs to.

`replyMarkup` - The new message reply markup; for bots only.

`location` - New location content of the message; may be null. Pass null to stop sharing the
live location.

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html) Describes a message.

