[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [sendCallDebugInformation](./send-call-debug-information.md)

# sendCallDebugInformation

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.sendCallDebugInformation(callId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, debugInformation: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sends debug information for a call.

### Parameters

`callId` - Call identifier.

`debugInformation` - Debug information in application-specific format.