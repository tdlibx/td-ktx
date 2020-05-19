[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [editInlineMessageCaption](./edit-inline-message-caption.md)

# editInlineMessageCaption

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.editInlineMessageCaption(inlineMessageId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ReplyMarkup.html)`?, caption: `[`FormattedText`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.FormattedText.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which edits the caption of an inline message sent via a bot; for bots only.

### Parameters

`inlineMessageId` - Inline message identifier.

`replyMarkup` - The new message reply markup.

`caption` - New message content caption; 0-GetOption(&amp;quot;message_caption_length_max&amp;quot;)
characters.