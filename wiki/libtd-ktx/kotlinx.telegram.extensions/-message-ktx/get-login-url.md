[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [MessageKtx](index.md) / [getLoginUrl](./get-login-url.md)

# getLoginUrl

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.getLoginUrl(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, buttonId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, allowWriteAccess: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`HttpUrl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html)

Suspend function, which returns an HTTP URL which can be used to automatically authorize the
user on a website after clicking an inline button of type inlineKeyboardButtonTypeLoginUrl. Use
the method getLoginUrlInfo to find whether a prior user confirmation is needed. If an error is
returned, then the button must be handled as an ordinary URL button.

### Parameters

`chatId` - Chat identifier of the message with the button.

`buttonId` - Button identifier.

`allowWriteAccess` - True, if the user allowed the bot to send them messages.

**Return**
[TdApi.HttpUrl](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html) Contains an HTTP URL.

