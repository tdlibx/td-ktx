---
title: ChatKtx.getMessageLink - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [getMessageLink](./get-message-link.html)

# getMessageLink

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.getMessageLink(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`HttpUrl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html)

Suspend function, which returns a private HTTPS link to a message in a chat. Available only for
already sent messages in supergroups and channels. The link will work only for members of the
chat.

### Parameters

`messageId` - Identifier of the message.

**Return**
[TdApi.HttpUrl](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html) Contains an HTTP URL.

