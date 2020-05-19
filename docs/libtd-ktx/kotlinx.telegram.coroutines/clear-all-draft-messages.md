---
title: clearAllDraftMessages - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [clearAllDraftMessages](./clear-all-draft-messages.html)

# clearAllDraftMessages

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.clearAllDraftMessages(excludeSecretChats: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which clears draft messages in all chats.

### Parameters

`excludeSecretChats` - If true, local draft messages in secret chats will not be cleared.