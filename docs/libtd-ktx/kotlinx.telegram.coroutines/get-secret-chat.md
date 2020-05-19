---
title: getSecretChat - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getSecretChat](./get-secret-chat.html)

# getSecretChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getSecretChat(secretChatId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`SecretChat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html)

Suspend function, which returns information about a secret chat by its identifier. This is an
offline request.

### Parameters

`secretChatId` - Secret chat identifier.

**Return**
[SecretChat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SecretChat.html) Represents a secret chat.

