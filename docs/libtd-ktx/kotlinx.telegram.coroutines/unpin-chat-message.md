---
title: unpinChatMessage - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [unpinChatMessage](./unpin-chat-message.html)

# unpinChatMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.unpinChatMessage(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes the pinned message from a chat; requires canPinMessages rights in
the group or channel.

### Parameters

`chatId` - Identifier of the chat.