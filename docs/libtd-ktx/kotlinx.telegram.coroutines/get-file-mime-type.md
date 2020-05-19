---
title: getFileMimeType - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getFileMimeType](./get-file-mime-type.html)

# getFileMimeType

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getFileMimeType(fileName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Text`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Text.html)

Suspend function, which returns the MIME type of a file, guessed by its extension. Returns an
empty string on failure. This is an offline method. Can be called before authorization. Can be
called synchronously.

### Parameters

`fileName` - The name of the file or path to the file.

**Return**
[Text](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Text.html) Contains some text.

