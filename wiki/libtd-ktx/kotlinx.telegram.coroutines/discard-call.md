[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [discardCall](./discard-call.md)

# discardCall

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.discardCall(callId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, isDisconnected: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, duration: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, connectionId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which discards a call.

### Parameters

`callId` - Call identifier.

`isDisconnected` - True, if the user was disconnected.

`duration` - The call duration, in seconds.

`connectionId` - Identifier of the connection used during the call.