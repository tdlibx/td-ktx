---
title: ChatKtx.setPermissions - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [setPermissions](./set-permissions.html)

# setPermissions

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.setPermissions(permissions: `[`ChatPermissions`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatPermissions.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the chat members permissions. Supported only for basic groups
and supergroups. Requires canRestrictMembers administrator right.

### Parameters

`permissions` - New non-administrator members permissions in the chat.