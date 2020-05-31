---
title: getChatMessageCount - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getChatMessageCount](./get-chat-message-count.html)

# getChatMessageCount

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getChatMessageCount(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, filter: `[`SearchMessagesFilter`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SearchMessagesFilter.html)`?, returnLocal: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Count`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Count.html)

Suspend function, which returns approximate number of messages of the specified type in the chat.

### Parameters

`chatId` - Identifier of the chat in which to count messages.

`filter` - Filter for message content; searchMessagesFilterEmpty is unsupported in this
function.

`returnLocal` - If true, returns count that is available locally without sending network
requests, returning -1 if the number of messages is unknown.

**Return**
[Count](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Count.html) Contains a counter.

