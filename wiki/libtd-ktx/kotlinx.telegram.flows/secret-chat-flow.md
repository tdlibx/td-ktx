[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [secretChatFlow](./secret-chat-flow.md)

# secretChatFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.secretChatFlow(): Flow<`[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html)`>`

emits [SecretChat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html) if some data of a secret chat has changed. This update is guaranteed to come
before the secret chat identifier is returned to the client.

