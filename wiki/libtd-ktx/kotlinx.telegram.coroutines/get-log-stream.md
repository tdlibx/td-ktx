[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getLogStream](./get-log-stream.md)

# getLogStream

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getLogStream(): `[`LogStream`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LogStream.html)

Suspend function, which returns information about currently used log stream for internal logging
of TDLib. This is an offline method. Can be called before authorization. Can be called
synchronously.

**Return**
[LogStream](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LogStream.html) This class is an abstract base class.

