---
title: getLogVerbosityLevel - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getLogVerbosityLevel](./get-log-verbosity-level.html)

# getLogVerbosityLevel

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getLogVerbosityLevel(): `[`LogVerbosityLevel`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LogVerbosityLevel.html)

Suspend function, which returns current verbosity level of the internal logging of TDLib. This is
an offline method. Can be called before authorization. Can be called synchronously.

**Return**
[LogVerbosityLevel](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LogVerbosityLevel.html) Contains a TDLib internal log verbosity level.

