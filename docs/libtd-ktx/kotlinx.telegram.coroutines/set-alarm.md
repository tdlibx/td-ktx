---
title: setAlarm - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setAlarm](./set-alarm.html)

# setAlarm

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setAlarm(seconds: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which succeeds after a specified amount of time has passed. Can be called
before authorization. Can be called before initialization.

### Parameters

`seconds` - Number of seconds before the function returns.