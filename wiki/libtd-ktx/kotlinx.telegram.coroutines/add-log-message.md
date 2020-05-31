[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [addLogMessage](./add-log-message.md)

# addLogMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.addLogMessage(verbosityLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds a message to TDLib internal log. This is an offline method. Can be
called before authorization. Can be called synchronously.

### Parameters

`verbosityLevel` - The minimum verbosity level needed for the message to be logged, 0-1023.

`text` - Text of a message to log.