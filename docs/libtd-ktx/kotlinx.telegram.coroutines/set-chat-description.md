---
title: setChatDescription - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setChatDescription](./set-chat-description.html)

# setChatDescription

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setChatDescription(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes information about a chat. Available for basic groups,
supergroups, and channels. Requires canChangeInfo rights.

### Parameters

`chatId` - Identifier of the chat.

`description` - New chat description; 0-255 characters.