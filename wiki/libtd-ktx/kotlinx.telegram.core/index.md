[libtd-ktx](../index.md) / [kotlinx.telegram.core](./index.md)

## Package kotlinx.telegram.core

Contains core elements of the library to communicate with Telegram API.

### Types

| Name | Summary |
|---|---|
| [ResultHandlerChannelFlow](-result-handler-channel-flow/index.md) | Class that converts results handler from [TdApi](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.html) client to [Flow](#) of the [TdApi.Object](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html) using [ConflatedBroadcastChannel](#)`class ResultHandlerChannelFlow : ResultHandlerFlow` |
| [TelegramFlow](-telegram-flow/index.md) | Main class to interact with Telegram API client`class TelegramFlow : Flow<`[`Object`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html)`>, `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html) |

### Exceptions

| Name | Summary |
|---|---|
| [TelegramException](-telegram-exception/index.md) | `sealed class TelegramException : `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |
