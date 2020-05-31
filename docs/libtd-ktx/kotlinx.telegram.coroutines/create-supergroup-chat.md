---
title: createSupergroupChat - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [createSupergroupChat](./create-supergroup-chat.html)

# createSupergroupChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.createSupergroupChat(supergroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, force: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)

Suspend function, which returns an existing chat corresponding to a known supergroup or channel.

### Parameters

`supergroupId` - Supergroup or channel identifier.

`force` - If true, the chat will be created without network request. In this case all
information about the chat except its type, title and photo can be incorrect.

**Return**
[Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

