---
title: ChatKtx.getPublicMessageLink - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [getPublicMessageLink](./get-public-message-link.html)

# getPublicMessageLink

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.getPublicMessageLink(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, forAlbum: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`PublicMessageLink`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PublicMessageLink.html)

Suspend function, which returns a public HTTPS link to a message. Available only for messages
in supergroups and channels with a username.

### Parameters

`messageId` - Identifier of the message.

`forAlbum` - Pass true if a link for a whole media album should be returned.

**Return**
[TdApi.PublicMessageLink](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PublicMessageLink.html) Contains a public HTTPS link to a message in a supergroup or
channel with a username.

