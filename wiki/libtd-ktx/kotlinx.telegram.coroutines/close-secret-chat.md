[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [closeSecretChat](./close-secret-chat.md)

# closeSecretChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.closeSecretChat(secretChatId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which closes a secret chat, effectively transferring its state to
secretChatStateClosed.

### Parameters

`secretChatId` - Secret chat identifier.