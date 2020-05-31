---
title: getTemporaryPasswordState - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getTemporaryPasswordState](./get-temporary-password-state.html)

# getTemporaryPasswordState

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getTemporaryPasswordState(): `[`TemporaryPasswordState`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TemporaryPasswordState.html)

Suspend function, which returns information about the current temporary password.

**Return**
[TemporaryPasswordState](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TemporaryPasswordState.html) Returns information about the availability of a temporary
password, which can be used for payments.

