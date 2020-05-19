---
title: toggleChatIsPinned - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [toggleChatIsPinned](./toggle-chat-is-pinned.html)

# toggleChatIsPinned

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.toggleChatIsPinned(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, isPinned: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the pinned state of a chat. You can pin up to
GetOption(&amp;quot;pinned_chat_count_max&amp;quot;)/GetOption(&amp;quot;pinned_archived_chat_count_max&amp;quot;)
non-secret chats and the same number of secret chats in the main/archive chat list.

### Parameters

`chatId` - Chat identifier.

`isPinned` - New value of isPinned.