[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [closeChat](./close-chat.md)

# closeChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.closeChat(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs TDLib that the chat is closed by the user. Many useful activities
depend on the chat being opened or closed.

### Parameters

`chatId` - Chat identifier.