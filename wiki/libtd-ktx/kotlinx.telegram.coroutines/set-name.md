[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setName](./set-name.md)

# setName

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setName(firstName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, lastName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the first and last name of the current user. If something
changes, updateUser will be sent.

### Parameters

`firstName` - The new value of the first name for the user; 1-64 characters.

`lastName` - The new value of the optional last name for the user; 0-64 characters.