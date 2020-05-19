---
title: setChatSlowModeDelay - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setChatSlowModeDelay](./set-chat-slow-mode-delay.html)

# setChatSlowModeDelay

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setChatSlowModeDelay(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, slowModeDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the slow mode delay of a chat. Available only for supergroups;
requires canRestrictMembers rights.

### Parameters

`chatId` - Chat identifier.

`slowModeDelay` - New slow mode delay for the chat; must be one of 0, 10, 30, 60, 300, 900,