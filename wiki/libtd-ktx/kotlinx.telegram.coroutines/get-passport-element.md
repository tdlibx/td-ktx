[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getPassportElement](./get-passport-element.md)

# getPassportElement

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getPassportElement(type: `[`PassportElementType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PassportElementType.html)`?, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`PassportElement`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PassportElement.html)

Suspend function, which returns one of the available Telegram Passport elements.

### Parameters

`type` - Telegram Passport element type.

`password` - Password of the current user.

**Return**
[PassportElement](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PassportElement.html) This class is an abstract base class.

