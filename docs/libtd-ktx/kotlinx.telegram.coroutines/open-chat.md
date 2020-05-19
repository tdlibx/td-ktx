---
title: openChat - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [openChat](./open-chat.html)

# openChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.openChat(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs TDLib that the chat is opened by the user. Many useful activities
depend on the chat being opened or closed (e.g., in supergroups and channels all updates are
received only for opened chats).

### Parameters

`chatId` - Chat identifier.