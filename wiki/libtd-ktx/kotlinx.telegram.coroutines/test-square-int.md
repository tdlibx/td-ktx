[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [testSquareInt](./test-square-int.md)

# testSquareInt

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.testSquareInt(x: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`TestInt`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TestInt.html)

Suspend function, which returns the squared received number; for testing only. This is an offline
method. Can be called before authorization.

### Parameters

`x` - Number to square.

**Return**
[TestInt](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TestInt.html) A simple object containing a number; for testing only.

