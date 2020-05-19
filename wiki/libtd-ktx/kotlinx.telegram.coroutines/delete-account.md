[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [deleteAccount](./delete-account.md)

# deleteAccount

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.deleteAccount(reason: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes the account of the current user, deleting all information
associated with the user from the server. The phone number of the account can be used to create a
new account. Can be called before authorization when the current authorization state is
authorizationStateWaitPassword.

### Parameters

`reason` - The reason why the account was deleted; optional.