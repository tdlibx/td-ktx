[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [createSecretChat](./create-secret-chat.md)

# createSecretChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.createSecretChat(secretChatId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)

Suspend function, which returns an existing chat corresponding to a known secret chat.

### Parameters

`secretChatId` - Secret chat identifier.

**Return**
[Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

