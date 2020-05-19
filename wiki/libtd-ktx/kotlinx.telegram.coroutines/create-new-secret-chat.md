[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [createNewSecretChat](./create-new-secret-chat.md)

# createNewSecretChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.createNewSecretChat(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)

Suspend function, which creates a new secret chat. Returns the newly created chat.

### Parameters

`userId` - Identifier of the target user.

**Return**
[Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

