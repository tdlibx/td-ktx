[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [editMessageMedia](./edit-message-media.md)

# editMessageMedia

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.editMessageMedia(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ReplyMarkup.html)`?, inputMessageContent: `[`InputMessageContent`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputMessageContent.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)

Suspend function, which edits the content of a message with an animation, an audio, a document,
a photo or a video. The media in the message can't be replaced if the message was set to
self-destruct. Media can't be replaced by self-destructing media. Media in an album can be edited
only to contain a photo or a video. Returns the edited message after the edit is completed on the
server side.

### Parameters

`messageId` - Identifier of the message.

`replyMarkup` - The new message reply markup; for bots only.

`inputMessageContent` - New content of the message. Must be one of the following types:
InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or
InputMessageVideo.

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html) Describes a message.

