[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [editInlineMessageMedia](./edit-inline-message-media.md)

# editInlineMessageMedia

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.editInlineMessageMedia(inlineMessageId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ReplyMarkup.html)`?, inputMessageContent: `[`InputMessageContent`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputMessageContent.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which edits the content of a message with an animation, an audio, a document, a
photo or a video in an inline message sent via a bot; for bots only.

### Parameters

`inlineMessageId` - Inline message identifier.

`replyMarkup` - The new message reply markup; for bots only.

`inputMessageContent` - New content of the message. Must be one of the following types:
InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or
InputMessageVideo.