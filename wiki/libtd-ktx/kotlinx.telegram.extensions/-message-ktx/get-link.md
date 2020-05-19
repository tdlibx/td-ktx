[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [MessageKtx](index.md) / [getLink](./get-link.md)

# getLink

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.getLink(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`HttpUrl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html)

Suspend function, which returns a private HTTPS link to a message in a chat. Available only for
already sent messages in supergroups and channels. The link will work only for members of the
chat.

### Parameters

`chatId` - Identifier of the chat to which the message belongs.

**Return**
[TdApi.HttpUrl](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html) Contains an HTTP URL.

