[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [saveApplicationLogEvent](./save-application-log-event.md)

# saveApplicationLogEvent

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.saveApplicationLogEvent(type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, data: `[`JsonValue`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.JsonValue.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which saves application log event on the server. Can be called before
authorization.

### Parameters

`type` - Event type.

`data` - The log event data.