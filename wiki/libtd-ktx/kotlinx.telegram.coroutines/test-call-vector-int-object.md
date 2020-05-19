[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [testCallVectorIntObject](./test-call-vector-int-object.md)

# testCallVectorIntObject

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.testCallVectorIntObject(x: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`TestInt`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestInt.html)`>?): `[`TestVectorIntObject`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestVectorIntObject.html)

Suspend function, which returns the received vector of objects containing a number; for testing
only. This is an offline method. Can be called before authorization.

### Parameters

`x` - Vector of objects to return.

**Return**
[TestVectorIntObject](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestVectorIntObject.html) A simple object containing a vector of objects that hold a number;
for testing only.

