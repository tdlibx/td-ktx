---
title: getChats - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getChats](./get-chats.html)

# getChats

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getChats(chatList: `[`ChatList`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatList.html)`?, offsetOrder: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, offsetChatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Chats`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html)

Suspend function, which returns an ordered list of chats in a chat list. Chats are sorted by the
pair (order, chatId) in decreasing order. (For example, to get a list of chats from the beginning,
the offsetOrder should be equal to a biggest signed 64-bit number 9223372036854775807 == 2^63 - 1).
For optimal performance the number of returned chats is chosen by the library.

### Parameters

`chatList` - The chat list in which to return chats.

`offsetOrder` - Chat order to return chats from.

`offsetChatId` - Chat identifier to return chats from.

`limit` - The maximum number of chats to be returned. It is possible that fewer chats than the
limit are returned even if the end of the list is not reached.

**Return**
[Chats](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html) Represents a list of chats.

