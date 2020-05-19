[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [sendCustomRequest](./send-custom-request.md)

# sendCustomRequest

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.sendCustomRequest(method: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, parameters: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`CustomRequestResult`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CustomRequestResult.html)

Suspend function, which sends a custom request; for bots only.

### Parameters

`method` - The method name.

`parameters` - JSON-serialized method parameters.

**Return**
[CustomRequestResult](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CustomRequestResult.html) Contains the result of a custom request.

