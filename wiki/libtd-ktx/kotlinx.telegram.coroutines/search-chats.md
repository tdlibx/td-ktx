[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchChats](./search-chats.md)

# searchChats

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchChats(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Chats`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chats.html)

Suspend function, which searches for the specified query in the title and username of already
known chats, this is an offline request. Returns chats in the order seen in the chat list.

### Parameters

`query` - Query to search for. If the query is empty, returns up to 20 recently found chats.

`limit` - The maximum number of chats to be returned.

**Return**
[Chats](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chats.html) Represents a list of chats.

