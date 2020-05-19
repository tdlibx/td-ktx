[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [testCallString](./test-call-string.md)

# testCallString

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.testCallString(x: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`TestString`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestString.html)

Suspend function, which returns the received string; for testing only. This is an offline method.
Can be called before authorization.

### Parameters

`x` - String to return.

**Return**
[TestString](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestString.html) A simple object containing a string; for testing only.

