[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setLogStream](./set-log-stream.md)

# setLogStream

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setLogStream(logStream: `[`LogStream`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LogStream.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets new log stream for internal logging of TDLib. This is an offline
method. Can be called before authorization. Can be called synchronously.

### Parameters

`logStream` - New log stream.