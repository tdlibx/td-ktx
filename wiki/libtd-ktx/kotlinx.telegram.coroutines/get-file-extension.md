[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getFileExtension](./get-file-extension.md)

# getFileExtension

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getFileExtension(mimeType: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Text`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Text.html)

Suspend function, which returns the extension of a file, guessed by its MIME type. Returns an
empty string on failure. This is an offline method. Can be called before authorization. Can be
called synchronously.

### Parameters

`mimeType` - The MIME type of the file.

**Return**
[Text](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Text.html) Contains some text.

