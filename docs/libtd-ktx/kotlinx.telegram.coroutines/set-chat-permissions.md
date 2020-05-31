---
title: setChatPermissions - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setChatPermissions](./set-chat-permissions.html)

# setChatPermissions

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setChatPermissions(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, permissions: `[`ChatPermissions`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatPermissions.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the chat members permissions. Supported only for basic groups and
supergroups. Requires canRestrictMembers administrator right.

### Parameters

`chatId` - Chat identifier.

`permissions` - New non-administrator members permissions in the chat.