[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [requestAuthenticationPasswordRecovery](./request-authentication-password-recovery.md)

# requestAuthenticationPasswordRecovery

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.requestAuthenticationPasswordRecovery(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which requests to send a password recovery code to an email address that was
previously set up. Works only when the current authorization state is
authorizationStateWaitPassword.

