[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [editMessageReplyMarkup](./edit-message-reply-markup.md)

# editMessageReplyMarkup

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.editMessageReplyMarkup(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ReplyMarkup.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)

Suspend function, which edits the message reply markup; for bots only. Returns the edited message
after the edit is completed on the server side.

### Parameters

`chatId` - The chat the message belongs to.

`messageId` - Identifier of the message.

`replyMarkup` - The new message reply markup.

**Return**
[Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html) Describes a message.

