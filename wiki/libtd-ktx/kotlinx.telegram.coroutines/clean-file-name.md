[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [cleanFileName](./clean-file-name.md)

# cleanFileName

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.cleanFileName(fileName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Text`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Text.html)

Suspend function, which removes potentially dangerous characters from the name of a file. The
encoding of the file name is supposed to be UTF-8. Returns an empty string on failure. This is an
offline method. Can be called before authorization. Can be called synchronously.

### Parameters

`fileName` - File name or path to the file.

**Return**
[Text](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Text.html) Contains some text.

