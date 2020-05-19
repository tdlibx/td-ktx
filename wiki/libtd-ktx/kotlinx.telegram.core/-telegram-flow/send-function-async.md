[libtd-ktx](../../index.md) / [kotlinx.telegram.core](../index.md) / [TelegramFlow](index.md) / [sendFunctionAsync](./send-function-async.md)

# sendFunctionAsync

`suspend fun <reified ExpectedResult : `[`Object`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Object.html)`> sendFunctionAsync(function: `[`Function`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Function.html)`): ExpectedResult`

Sends a request to the TDLib and expect a result.

### Parameters

`function` - [TdApi.Function](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Function.html) representing a TDLib interface function-class.

`ExpectedResult` - result type expecting from given [function](send-function-async.md#kotlinx.telegram.core.TelegramFlow$sendFunctionAsync(org.drinkless.td.libcore.telegram.TdApi.Function)/function).

### Exceptions

`TelegramException.Error` - if TdApi request returns an exception

`TelegramException.UnexpectedResult` - if TdApi request returns an unexpected result

`TelegramException.ClientNotAttached` - if TdApi client has not attached yet