[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getSecretChat](./get-secret-chat.md)

# getSecretChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getSecretChat(secretChatId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SecretChat.html)

Suspend function, which returns information about a secret chat by its identifier. This is an
offline request.

### Parameters

`secretChatId` - Secret chat identifier.

**Return**
[SecretChat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SecretChat.html) Represents a secret chat.

