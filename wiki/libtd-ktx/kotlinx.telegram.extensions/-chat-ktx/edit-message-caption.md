[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [editMessageCaption](./edit-message-caption.md)

# editMessageCaption

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.editMessageCaption(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ReplyMarkup.html)`?, caption: `[`FormattedText`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/FormattedText.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)

Suspend function, which edits the message content caption. Returns the edited message after the
edit is completed on the server side.

### Parameters

`messageId` - Identifier of the message.

`replyMarkup` - The new message reply markup; for bots only.

`caption` - New message content caption; 0-GetOption(&amp;quot;message_caption_length_max&amp;quot;)
characters.

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html) Describes a message.

