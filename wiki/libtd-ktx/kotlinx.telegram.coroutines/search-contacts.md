[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchContacts](./search-contacts.md)

# searchContacts

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchContacts(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Users`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Users.html)

Suspend function, which searches for the specified query in the first names, last names and
usernames of the known user contacts.

### Parameters

`query` - Query to search for; may be empty to return all contacts.

`limit` - The maximum number of users to be returned.

**Return**
[Users](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Users.html) Represents a list of users.

