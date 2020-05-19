---
title: setLogTagVerbosityLevel - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setLogTagVerbosityLevel](./set-log-tag-verbosity-level.html)

# setLogTagVerbosityLevel

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setLogTagVerbosityLevel(tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, newVerbosityLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets the verbosity level for a specified TDLib internal log tag. This is
an offline method. Can be called before authorization. Can be called synchronously.

### Parameters

`tag` - Logging tag to change verbosity level.

`newVerbosityLevel` - New verbosity level; 1-1024.