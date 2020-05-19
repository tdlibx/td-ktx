[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [sendMessageAlbum](./send-message-album.md)

# sendMessageAlbum

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.sendMessageAlbum(replyToMessageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, options: `[`SendMessageOptions`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SendMessageOptions.html)`?, inputMessageContents: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`InputMessageContent`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputMessageContent.html)`>?): `[`Messages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Messages.html)

Suspend function, which sends messages grouped together into an album. Currently only photo and
video messages can be grouped into an album. Returns sent messages.

### Parameters

`replyToMessageId` - Identifier of a message to reply to or 0.

`options` - Options to be used to send the messages.

`inputMessageContents` - Contents of messages to be sent.

**Return**
[TdApi.Messages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Messages.html) Contains a list of messages.

