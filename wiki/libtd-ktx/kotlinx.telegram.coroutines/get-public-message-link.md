[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getPublicMessageLink](./get-public-message-link.md)

# getPublicMessageLink

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getPublicMessageLink(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, forAlbum: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`PublicMessageLink`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PublicMessageLink.html)

Suspend function, which returns a public HTTPS link to a message. Available only for messages in
supergroups and channels with a username.

### Parameters

`chatId` - Identifier of the chat to which the message belongs.

`messageId` - Identifier of the message.

`forAlbum` - Pass true if a link for a whole media album should be returned.

**Return**
[PublicMessageLink](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PublicMessageLink.html) Contains a public HTTPS link to a message in a supergroup or channel
with a username.

