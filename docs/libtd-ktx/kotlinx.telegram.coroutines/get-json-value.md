---
title: getJsonValue - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getJsonValue](./get-json-value.html)

# getJsonValue

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getJsonValue(json: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`JsonValue`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/JsonValue.html)

Suspend function, which converts a JSON-serialized string to corresponding JsonValue object. This
is an offline method. Can be called before authorization. Can be called synchronously.

### Parameters

`json` - The JSON-serialized string.

**Return**
[JsonValue](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/JsonValue.html) This class is an abstract base class.

