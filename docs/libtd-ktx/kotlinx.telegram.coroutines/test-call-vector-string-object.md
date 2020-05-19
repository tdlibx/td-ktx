---
title: testCallVectorStringObject - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [testCallVectorStringObject](./test-call-vector-string-object.html)

# testCallVectorStringObject

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.testCallVectorStringObject(x: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`TestString`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestString.html)`>?): `[`TestVectorStringObject`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestVectorStringObject.html)

Suspend function, which returns the received vector of objects containing a string; for testing
only. This is an offline method. Can be called before authorization.

### Parameters

`x` - Vector of objects to return.

**Return**
[TestVectorStringObject](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TestVectorStringObject.html) A simple object containing a vector of objects that hold a
string; for testing only.

