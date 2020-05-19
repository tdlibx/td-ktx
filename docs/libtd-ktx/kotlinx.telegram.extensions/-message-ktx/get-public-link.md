---
title: MessageKtx.getPublicLink - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [MessageKtx](index.html) / [getPublicLink](./get-public-link.html)

# getPublicLink

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.getPublicLink(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, forAlbum: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`PublicMessageLink`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PublicMessageLink.html)

Suspend function, which returns a public HTTPS link to a message. Available only for messages
in supergroups and channels with a username.

### Parameters

`chatId` - Identifier of the chat to which the message belongs.

`forAlbum` - Pass true if a link for a whole media album should be returned.

**Return**
[TdApi.PublicMessageLink](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PublicMessageLink.html) Contains a public HTTPS link to a message in a supergroup or
channel with a username.

