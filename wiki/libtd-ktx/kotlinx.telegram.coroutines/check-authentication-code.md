[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [checkAuthenticationCode](./check-authentication-code.md)

# checkAuthenticationCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.checkAuthenticationCode(code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which checks the authentication code. Works only when the current authorization
state is authorizationStateWaitCode.

### Parameters

`code` - The verification code received via SMS, Telegram message, phone call, or flash call.