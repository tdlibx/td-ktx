[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [searchMembers](./search-members.md)

# searchMembers

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.searchMembers(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, filter: `[`ChatMembersFilter`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatMembersFilter.html)`?): `[`ChatMembers`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatMembers.html)

Suspend function, which searches for a specified query in the first name, last name and
username of the members of a specified chat. Requires administrator rights in channels.

### Parameters

`query` - Query to search for.

`limit` - The maximum number of users to be returned.

`filter` - The type of users to return. By default, chatMembersFilterMembers.

**Return**
[TdApi.ChatMembers](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatMembers.html) Contains a list of chat members.

