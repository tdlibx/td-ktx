[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getPassportAuthorizationForm](./get-passport-authorization-form.md)

# getPassportAuthorizationForm

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getPassportAuthorizationForm(botUserId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, scope: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, publicKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, nonce: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`PassportAuthorizationForm`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PassportAuthorizationForm.html)

Suspend function, which returns a Telegram Passport authorization form for sharing data with a
service.

### Parameters

`botUserId` - User identifier of the service's bot.

`scope` - Telegram Passport element types requested by the service.

`publicKey` - Service's publicKey.

`nonce` - Authorization form nonce provided by the service.

**Return**
[PassportAuthorizationForm](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PassportAuthorizationForm.html) Contains information about a Telegram Passport authorization
form that was requested.

