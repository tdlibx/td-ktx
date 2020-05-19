[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setTdlibParameters](./set-tdlib-parameters.md)

# setTdlibParameters

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setTdlibParameters(parameters: `[`TdlibParameters`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TdlibParameters.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets the parameters for TDLib initialization. Works only when the current
authorization state is authorizationStateWaitTdlibParameters.

### Parameters

`parameters` - Parameters.