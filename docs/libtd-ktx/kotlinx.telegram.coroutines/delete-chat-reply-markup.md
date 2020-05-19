---
title: deleteChatReplyMarkup - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [deleteChatReplyMarkup](./delete-chat-reply-markup.html)

# deleteChatReplyMarkup

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.deleteChatReplyMarkup(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes the default reply markup from a chat. Must be called after a
one-time keyboard or a ForceReply reply markup has been used. UpdateChatReplyMarkup will be sent if
the reply markup will be changed.

### Parameters

`chatId` - Chat identifier.

`messageId` - The message identifier of the used keyboard.