[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getLoginUrlInfo](./get-login-url-info.md)

# getLoginUrlInfo

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getLoginUrlInfo(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, buttonId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`LoginUrlInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LoginUrlInfo.html)

Suspend function, which returns information about a button of type
inlineKeyboardButtonTypeLoginUrl. The method needs to be called when the user presses the button.

### Parameters

`chatId` - Chat identifier of the message with the button.

`messageId` - Message identifier of the message with the button.

`buttonId` - Button identifier.

**Return**
[LoginUrlInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LoginUrlInfo.html) This class is an abstract base class.

