---
title: sendChatScreenshotTakenNotification - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [sendChatScreenshotTakenNotification](./send-chat-screenshot-taken-notification.html)

# sendChatScreenshotTakenNotification

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.sendChatScreenshotTakenNotification(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sends a notification about a screenshot taken in a chat. Supported only
in private and secret chats.

### Parameters

`chatId` - Chat identifier.