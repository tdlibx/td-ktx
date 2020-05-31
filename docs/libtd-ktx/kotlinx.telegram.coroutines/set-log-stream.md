---
title: setLogStream - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setLogStream](./set-log-stream.html)

# setLogStream

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setLogStream(logStream: `[`LogStream`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LogStream.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets new log stream for internal logging of TDLib. This is an offline
method. Can be called before authorization. Can be called synchronously.

### Parameters

`logStream` - New log stream.