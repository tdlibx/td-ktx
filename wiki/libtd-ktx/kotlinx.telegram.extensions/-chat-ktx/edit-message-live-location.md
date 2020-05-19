[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [editMessageLiveLocation](./edit-message-live-location.md)

# editMessageLiveLocation

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.editMessageLiveLocation(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ReplyMarkup.html)`?, location: `[`Location`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Location.html)`? = null): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which edits the message content of a live location. Messages can be edited
for a limited period of time specified in the live location. Returns the edited message after the
edit is completed on the server side.

### Parameters

`messageId` - Identifier of the message.

`replyMarkup` - The new message reply markup; for bots only.

`location` - New location content of the message; may be null. Pass null to stop sharing the
live location.

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

