---
title: testCallBytes - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [testCallBytes](./test-call-bytes.html)

# testCallBytes

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.testCallBytes(x: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?): `[`TestBytes`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestBytes.html)

Suspend function, which returns the received bytes; for testing only. This is an offline method.
Can be called before authorization.

### Parameters

`x` - Bytes to return.

**Return**
[TestBytes](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestBytes.html) A simple object containing a sequence of bytes; for testing only.

