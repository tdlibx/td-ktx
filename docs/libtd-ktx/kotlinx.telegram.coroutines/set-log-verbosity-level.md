---
title: setLogVerbosityLevel - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setLogVerbosityLevel](./set-log-verbosity-level.html)

# setLogVerbosityLevel

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setLogVerbosityLevel(newVerbosityLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets the verbosity level of the internal logging of TDLib. This is an
offline method. Can be called before authorization. Can be called synchronously.

### Parameters

`newVerbosityLevel` - New value of the verbosity level for logging. Value 0 corresponds to
fatal errors, value 1 corresponds to errors, value 2 corresponds to warnings and debug warnings,
value 3 corresponds to informational, value 4 corresponds to debug, value 5 corresponds to verbose
debug, value greater than 5 and up to 1023 can be used to enable even more logging.