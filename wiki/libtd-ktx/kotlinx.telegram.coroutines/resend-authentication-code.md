[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [resendAuthenticationCode](./resend-authentication-code.md)

# resendAuthenticationCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.resendAuthenticationCode(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which re-sends an authentication code to the user. Works only when the current
authorization state is authorizationStateWaitCode and the nextCodeType of the result is not null.

