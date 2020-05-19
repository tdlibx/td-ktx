[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [editMessageText](./edit-message-text.md)

# editMessageText

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.editMessageText(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ReplyMarkup.html)`?, inputMessageContent: `[`InputMessageContent`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputMessageContent.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which edits the text of a message (or a text of a game message). Returns the
edited message after the edit is completed on the server side.

### Parameters

`messageId` - Identifier of the message.

`replyMarkup` - The new message reply markup; for bots only.

`inputMessageContent` - New text content of the message. Should be of type InputMessageText.

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

