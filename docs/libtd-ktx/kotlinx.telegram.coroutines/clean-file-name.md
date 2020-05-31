---
title: cleanFileName - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [cleanFileName](./clean-file-name.html)

# cleanFileName

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.cleanFileName(fileName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Text`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Text.html)

Suspend function, which removes potentially dangerous characters from the name of a file. The
encoding of the file name is supposed to be UTF-8. Returns an empty string on failure. This is an
offline method. Can be called before authorization. Can be called synchronously.

### Parameters

`fileName` - File name or path to the file.

**Return**
[Text](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Text.html) Contains some text.

