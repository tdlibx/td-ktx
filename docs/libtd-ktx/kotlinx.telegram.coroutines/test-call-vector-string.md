---
title: testCallVectorString - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [testCallVectorString](./test-call-vector-string.html)

# testCallVectorString

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.testCallVectorString(x: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`TestVectorString`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TestVectorString.html)

Suspend function, which returns the received vector of strings; for testing only. This is an
offline method. Can be called before authorization.

### Parameters

`x` - Vector of strings to return.

**Return**
[TestVectorString](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TestVectorString.html) A simple object containing a vector of strings; for testing only.

