[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getPassportAuthorizationFormAvailableElements](./get-passport-authorization-form-available-elements.md)

# getPassportAuthorizationFormAvailableElements

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getPassportAuthorizationFormAvailableElements(autorizationFormId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`PassportElementsWithErrors`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PassportElementsWithErrors.html)

Suspend function, which returns already available Telegram Passport elements suitable for
completing a Telegram Passport authorization form. Result can be received only once for each
authorization form.

### Parameters

`autorizationFormId` - Authorization form identifier.

`password` - Password of the current user.

**Return**
[PassportElementsWithErrors](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PassportElementsWithErrors.html) Contains information about a Telegram Passport elements and
corresponding errors.

