---
title: secretChatFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [secretChatFlow](./secret-chat-flow.html)

# secretChatFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.secretChatFlow(): Flow<`[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html)`>`

emits [SecretChat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html) if some data of a secret chat has changed. This update is guaranteed to come
before the secret chat identifier is returned to the client.

