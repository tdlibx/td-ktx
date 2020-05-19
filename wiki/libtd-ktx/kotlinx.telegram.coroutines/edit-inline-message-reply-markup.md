[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [editInlineMessageReplyMarkup](./edit-inline-message-reply-markup.md)

# editInlineMessageReplyMarkup

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.editInlineMessageReplyMarkup(inlineMessageId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ReplyMarkup.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which edits the reply markup of an inline message sent via a bot; for bots
only.

### Parameters

`inlineMessageId` - Inline message identifier.

`replyMarkup` - The new message reply markup.