---
title: setTdlibParameters - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setTdlibParameters](./set-tdlib-parameters.html)

# setTdlibParameters

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setTdlibParameters(parameters: `[`TdlibParameters`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TdlibParameters.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets the parameters for TDLib initialization. Works only when the current
authorization state is authorizationStateWaitTdlibParameters.

### Parameters

`parameters` - Parameters.