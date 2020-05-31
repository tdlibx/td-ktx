---
title: ChatKtx.searchSecretMessages - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [searchSecretMessages](./search-secret-messages.html)

# searchSecretMessages

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.searchSecretMessages(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, fromSearchId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, filter: `[`SearchMessagesFilter`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SearchMessagesFilter.html)`?): `[`FoundMessages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.FoundMessages.html)

Suspend function, which searches for messages in secret chats. Returns the results in reverse
chronological order. For optimal performance the number of returned messages is chosen by the
library.

### Parameters

`query` - Query to search for. If empty, searchChatMessages should be used instead.

`fromSearchId` - The identifier from the result of a previous request, use 0 to get results
from the last message.

`limit` - The maximum number of messages to be returned; up to 100. Fewer messages may be
returned than specified by the limit, even if the end of the message history has not been reached.

`filter` - A filter for the content of messages in the search results.

**Return**
[TdApi.FoundMessages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.FoundMessages.html) Contains a list of messages found by a search.

