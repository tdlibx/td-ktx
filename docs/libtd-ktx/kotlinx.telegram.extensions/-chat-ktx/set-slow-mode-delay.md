---
title: ChatKtx.setSlowModeDelay - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [setSlowModeDelay](./set-slow-mode-delay.html)

# setSlowModeDelay

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.setSlowModeDelay(slowModeDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the slow mode delay of a chat. Available only for supergroups;
requires canRestrictMembers rights.

### Parameters

`slowModeDelay` - New slow mode delay for the chat; must be one of 0, 10, 30, 60, 300, 900,