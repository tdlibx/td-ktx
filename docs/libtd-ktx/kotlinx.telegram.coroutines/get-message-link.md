---
title: getMessageLink - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getMessageLink](./get-message-link.html)

# getMessageLink

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getMessageLink(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`HttpUrl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.HttpUrl.html)

Suspend function, which returns a private HTTPS link to a message in a chat. Available only for
already sent messages in supergroups and channels. The link will work only for members of the chat.

### Parameters

`chatId` - Identifier of the chat to which the message belongs.

`messageId` - Identifier of the message.

**Return**
[HttpUrl](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.HttpUrl.html) Contains an HTTP URL.

