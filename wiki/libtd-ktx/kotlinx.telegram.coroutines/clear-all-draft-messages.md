[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [clearAllDraftMessages](./clear-all-draft-messages.md)

# clearAllDraftMessages

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.clearAllDraftMessages(excludeSecretChats: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which clears draft messages in all chats.

### Parameters

`excludeSecretChats` - If true, local draft messages in secret chats will not be cleared.