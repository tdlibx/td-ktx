---
title: openMessageContent - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [openMessageContent](./open-message-content.html)

# openMessageContent

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.openMessageContent(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs TDLib that the message content has been opened (e.g., the user
has opened a photo, video, document, location or venue, or has listened to an audio file or voice
note message). An updateMessageContentOpened update will be generated if something has changed.

### Parameters

`chatId` - Chat identifier of the message.

`messageId` - Identifier of the message with the opened content.