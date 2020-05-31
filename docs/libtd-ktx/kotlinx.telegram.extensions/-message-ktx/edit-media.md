---
title: MessageKtx.editMedia - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [MessageKtx](index.html) / [editMedia](./edit-media.html)

# editMedia

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)`.editMedia(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ReplyMarkup.html)`?, inputMessageContent: `[`InputMessageContent`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputMessageContent.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which edits the content of a message with an animation, an audio, a document,
a photo or a video. The media in the message can't be replaced if the message was set to
self-destruct. Media can't be replaced by self-destructing media. Media in an album can be edited
only to contain a photo or a video. Returns the edited message after the edit is completed on the
server side.

### Parameters

`chatId` - The chat the message belongs to.

`replyMarkup` - The new message reply markup; for bots only.

`inputMessageContent` - New content of the message. Must be one of the following types:
InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or
InputMessageVideo.

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

