[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [sendMessage](./send-message.md)

# sendMessage

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.sendMessage(replyToMessageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, options: `[`SendMessageOptions`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SendMessageOptions.html)`?, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ReplyMarkup.html)`?, inputMessageContent: `[`InputMessageContent`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputMessageContent.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which sends a message. Returns the sent message.

### Parameters

`replyToMessageId` - Identifier of the message to reply to or 0.

`options` - Options to be used to send the message.

`replyMarkup` - Markup for replying to the message; for bots only.

`inputMessageContent` - The content of the message to be sent.

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

