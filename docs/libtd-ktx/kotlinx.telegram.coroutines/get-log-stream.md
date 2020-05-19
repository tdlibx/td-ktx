---
title: getLogStream - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getLogStream](./get-log-stream.html)

# getLogStream

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getLogStream(): `[`LogStream`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LogStream.html)

Suspend function, which returns information about currently used log stream for internal logging
of TDLib. This is an offline method. Can be called before authorization. Can be called
synchronously.

**Return**
[LogStream](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LogStream.html) This class is an abstract base class.

