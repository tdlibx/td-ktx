---
title: getTopChats - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getTopChats](./get-top-chats.html)

# getTopChats

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getTopChats(category: `[`TopChatCategory`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TopChatCategory.html)`?, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Chats`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html)

Suspend function, which returns a list of frequently used chats. Supported only if the chat info
database is enabled.

### Parameters

`category` - Category of chats to be returned.

`limit` - The maximum number of chats to be returned; up to 30.

**Return**
[Chats](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html) Represents a list of chats.

