---
title: kotlinx.telegram.core - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.core](./index.html)

## Package kotlinx.telegram.core

Contains core elements of the library to communicate with Telegram API.

### Types

| [ResultHandlerChannelFlow](-result-handler-channel-flow/index.html) | Class that converts results handler from [TdApi](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.html) client to [Flow](#) of the [TdApi.Object](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html) using [ConflatedBroadcastChannel](#)`class ResultHandlerChannelFlow : ResultHandlerFlow` |
| [TelegramFlow](-telegram-flow/index.html) | Main class to interact with Telegram API client`class TelegramFlow : Flow<`[`Object`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html)`>, `[`Closeable`](https://docs.oracle.com/javase/6/docs/api/java/io/Closeable.html) |

### Exceptions

| [TelegramException](-telegram-exception/index.html) | `sealed class TelegramException : `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |

