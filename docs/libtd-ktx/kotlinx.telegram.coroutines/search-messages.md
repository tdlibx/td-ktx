---
title: searchMessages - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [searchMessages](./search-messages.html)

# searchMessages

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.searchMessages(chatList: `[`ChatList`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatList.html)`?, query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, offsetDate: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, offsetChatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, offsetMessageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Messages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Messages.html)

Suspend function, which searches for messages in all chats except secret chats. Returns the
results in reverse chronological order (i.e., in order of decreasing (date, chatId, messageId)). For
optimal performance the number of returned messages is chosen by the library.

### Parameters

`chatList` - Chat list in which to search messages; pass null to search in all chats
regardless of their chat list.

`query` - Query to search for.

`offsetDate` - The date of the message starting from which the results should be fetched. Use
0 or any date in the future to get results from the last message.

`offsetChatId` - The chat identifier of the last found message, or 0 for the first request.

`offsetMessageId` - The message identifier of the last found message, or 0 for the first
request.

`limit` - The maximum number of messages to be returned, up to 100. Fewer messages may be
returned than specified by the limit, even if the end of the message history has not been reached.

**Return**
[Messages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Messages.html) Contains a list of messages.

