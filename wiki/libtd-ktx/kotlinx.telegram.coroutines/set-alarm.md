[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setAlarm](./set-alarm.md)

# setAlarm

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setAlarm(seconds: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which succeeds after a specified amount of time has passed. Can be called
before authorization. Can be called before initialization.

### Parameters

`seconds` - Number of seconds before the function returns.