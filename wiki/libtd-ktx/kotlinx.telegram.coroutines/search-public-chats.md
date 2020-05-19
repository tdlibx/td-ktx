[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchPublicChats](./search-public-chats.md)

# searchPublicChats

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchPublicChats(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Chats`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chats.html)

Suspend function, which searches public chats by looking for specified query in their username
and title. Currently only private chats, supergroups and channels can be public. Returns a
meaningful number of results. Returns nothing if the length of the searched username prefix is less
than 5. Excludes private chats with contacts and chats from the chat list from the results.

### Parameters

`query` - Query to search for.

**Return**
[Chats](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chats.html) Represents a list of chats.

