---
title: searchChatMembers - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [searchChatMembers](./search-chat-members.html)

# searchChatMembers

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.searchChatMembers(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, filter: `[`ChatMembersFilter`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatMembersFilter.html)`?): `[`ChatMembers`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatMembers.html)

Suspend function, which searches for a specified query in the first name, last name and username
of the members of a specified chat. Requires administrator rights in channels.

### Parameters

`chatId` - Chat identifier.

`query` - Query to search for.

`limit` - The maximum number of users to be returned.

`filter` - The type of users to return. By default, chatMembersFilterMembers.

**Return**
[ChatMembers](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatMembers.html) Contains a list of chat members.

