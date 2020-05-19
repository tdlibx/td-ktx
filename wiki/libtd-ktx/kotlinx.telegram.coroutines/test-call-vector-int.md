[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [testCallVectorInt](./test-call-vector-int.md)

# testCallVectorInt

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.testCallVectorInt(x: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`?): `[`TestVectorInt`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestVectorInt.html)

Suspend function, which returns the received vector of numbers; for testing only. This is an
offline method. Can be called before authorization.

### Parameters

`x` - Vector of numbers to return.

**Return**
[TestVectorInt](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestVectorInt.html) A simple object containing a vector of numbers; for testing only.

