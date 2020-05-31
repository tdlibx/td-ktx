---
title: ChatKtx.searchMessages - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [searchMessages](./search-messages.html)

# searchMessages

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.searchMessages(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, senderUserId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, fromMessageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, filter: `[`SearchMessagesFilter`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SearchMessagesFilter.html)`?): `[`Messages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Messages.html)

Suspend function, which searches for messages with given words in the chat. Returns the results
in reverse chronological order, i.e. in order of decreasing messageId. Cannot be used in secret
chats with a non-empty query (searchSecretMessages should be used instead), or without an enabled
message database. For optimal performance the number of returned messages is chosen by the
library.

### Parameters

`query` - Query to search for.

`senderUserId` - If not 0, only messages sent by the specified user will be returned. Not
supported in secret chats.

`fromMessageId` - Identifier of the message starting from which history must be fetched; use
0 to get results from the last message.

`offset` - Specify 0 to get results from exactly the fromMessageId or a negative offset to
get the specified message and some newer messages.

`limit` - The maximum number of messages to be returned; must be positive and can't be
greater than 100. If the offset is negative, the limit must be greater than -offset. Fewer
messages may be returned than specified by the limit, even if the end of the message history has
not been reached.

`filter` - Filter for message content in the search results.

**Return**
[TdApi.Messages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Messages.html) Contains a list of messages.

