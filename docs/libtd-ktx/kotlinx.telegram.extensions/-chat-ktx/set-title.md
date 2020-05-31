---
title: ChatKtx.setTitle - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [setTitle](./set-title.html)

# setTitle

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.setTitle(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the chat title. Supported only for basic groups, supergroups
and channels. Requires canChangeInfo rights. The title will not be changed until the request to
the server has been completed.

### Parameters

`title` - New title of the chat; 1-128 characters.