---
title: editMessageText - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [editMessageText](./edit-message-text.html)

# editMessageText

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.editMessageText(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ReplyMarkup.html)`?, inputMessageContent: `[`InputMessageContent`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputMessageContent.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which edits the text of a message (or a text of a game message). Returns the
edited message after the edit is completed on the server side.

### Parameters

`chatId` - The chat the message belongs to.

`messageId` - Identifier of the message.

`replyMarkup` - The new message reply markup; for bots only.

`inputMessageContent` - New text content of the message. Should be of type InputMessageText.

**Return**
[Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

