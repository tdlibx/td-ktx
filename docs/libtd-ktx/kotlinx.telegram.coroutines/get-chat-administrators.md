---
title: getChatAdministrators - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getChatAdministrators](./get-chat-administrators.html)

# getChatAdministrators

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getChatAdministrators(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`ChatAdministrators`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatAdministrators.html)

Suspend function, which returns a list of administrators of the chat with their custom titles.

### Parameters

`chatId` - Chat identifier.

**Return**
[ChatAdministrators](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatAdministrators.html) Represents a list of chat administrators.

