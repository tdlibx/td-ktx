[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [recoverAuthenticationPassword](./recover-authentication-password.md)

# recoverAuthenticationPassword

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.recoverAuthenticationPassword(recoveryCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which recovers the password with a password recovery code sent to an email
address that was previously set up. Works only when the current authorization state is
authorizationStateWaitPassword.

### Parameters

`recoveryCode` - Recovery code to check.