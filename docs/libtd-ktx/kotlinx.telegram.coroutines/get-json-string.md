---
title: getJsonString - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getJsonString](./get-json-string.html)

# getJsonString

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getJsonString(jsonValue: `[`JsonValue`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/JsonValue.html)`?): `[`Text`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Text.html)

Suspend function, which converts a JsonValue object to corresponding JSON-serialized string. This
is an offline method. Can be called before authorization. Can be called synchronously.

### Parameters

`jsonValue` - The JsonValue object.

**Return**
[Text](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Text.html) Contains some text.

