[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [registerUser](./register-user.md)

# registerUser

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.registerUser(firstName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, lastName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which finishes user registration. Works only when the current authorization
state is authorizationStateWaitRegistration.

### Parameters

`firstName` - The first name of the user; 1-64 characters.

`lastName` - The last name of the user; 0-64 characters.