[libtd-ktx](../../index.md) / [kotlinx.telegram.core](../index.md) / [TelegramFlow](index.md) / [sendFunctionLaunch](./send-function-launch.md)

# sendFunctionLaunch

`suspend fun sendFunctionLaunch(function: `[`Function`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Function.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sends a request to the TDLib and expect [TdApi.Ok](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Ok.html)

### Parameters

`function` - [TdApi.Function](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Function.html) representing a TDLib interface function-class.

### Exceptions

`TelegramException.Error` - if TdApi request returns an exception

`TelegramException.UnexpectedResult` - if TdApi request returns an unexpected result

`TelegramException.ClientNotAttached` - if TdApi client has not attached yet