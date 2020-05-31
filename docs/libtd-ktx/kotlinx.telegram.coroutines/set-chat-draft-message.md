---
title: setChatDraftMessage - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setChatDraftMessage](./set-chat-draft-message.html)

# setChatDraftMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setChatDraftMessage(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, draftMessage: `[`DraftMessage`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.DraftMessage.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the draft message in a chat.

### Parameters

`chatId` - Chat identifier.

`draftMessage` - New draft message; may be null.