[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [editInlineMessageText](./edit-inline-message-text.md)

# editInlineMessageText

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.editInlineMessageText(inlineMessageId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ReplyMarkup.html)`?, inputMessageContent: `[`InputMessageContent`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputMessageContent.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which edits the text of an inline text or game message sent via a bot; for bots
only.

### Parameters

`inlineMessageId` - Inline message identifier.

`replyMarkup` - The new message reply markup.

`inputMessageContent` - New text content of the message. Should be of type InputMessageText.