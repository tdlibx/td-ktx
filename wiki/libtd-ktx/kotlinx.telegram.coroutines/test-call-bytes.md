[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [testCallBytes](./test-call-bytes.md)

# testCallBytes

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.testCallBytes(x: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?): `[`TestBytes`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TestBytes.html)

Suspend function, which returns the received bytes; for testing only. This is an offline method.
Can be called before authorization.

### Parameters

`x` - Bytes to return.

**Return**
[TestBytes](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TestBytes.html) A simple object containing a sequence of bytes; for testing only.

