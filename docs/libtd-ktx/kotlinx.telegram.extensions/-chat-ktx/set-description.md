---
title: ChatKtx.setDescription - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [setDescription](./set-description.html)

# setDescription

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.setDescription(description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes information about a chat. Available for basic groups,
supergroups, and channels. Requires canChangeInfo rights.

### Parameters

`description` - New chat description; 0-255 characters.