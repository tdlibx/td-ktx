[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [MessageKtx](index.md) / [getLoginUrlInfo](./get-login-url-info.md)

# getLoginUrlInfo

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)`.getLoginUrlInfo(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, buttonId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`LoginUrlInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LoginUrlInfo.html)

Suspend function, which returns information about a button of type
inlineKeyboardButtonTypeLoginUrl. The method needs to be called when the user presses the button.

### Parameters

`chatId` - Chat identifier of the message with the button.

`buttonId` - Button identifier.

**Return**
[TdApi.LoginUrlInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LoginUrlInfo.html) This class is an abstract base class.

