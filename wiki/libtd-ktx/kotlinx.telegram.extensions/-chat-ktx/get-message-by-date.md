[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [getMessageByDate](./get-message-by-date.md)

# getMessageByDate

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.getMessageByDate(date: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)

Suspend function, which returns the last message sent in a chat no later than the specified
date.

### Parameters

`date` - Point in time (Unix timestamp) relative to which to search for messages.

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html) Describes a message.

