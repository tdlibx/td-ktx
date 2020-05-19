[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [checkAuthenticationPassword](./check-authentication-password.md)

# checkAuthenticationPassword

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.checkAuthenticationPassword(password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which checks the authentication password for correctness. Works only when the
current authorization state is authorizationStateWaitPassword.

### Parameters

`password` - The password to check.