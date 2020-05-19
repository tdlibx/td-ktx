[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchChatsOnServer](./search-chats-on-server.md)

# searchChatsOnServer

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchChatsOnServer(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Chats`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html)

Suspend function, which searches for the specified query in the title and username of already
known chats via request to the server. Returns chats in the order seen in the chat list.

### Parameters

`query` - Query to search for.

`limit` - The maximum number of chats to be returned.

**Return**
[Chats](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html) Represents a list of chats.

