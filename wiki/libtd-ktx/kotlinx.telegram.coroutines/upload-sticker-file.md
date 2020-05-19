[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [uploadStickerFile](./upload-sticker-file.md)

# uploadStickerFile

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.uploadStickerFile(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, pngSticker: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputFile.html)`?): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)

Suspend function, which uploads a PNG image with a sticker; for bots only; returns the uploaded
file.

### Parameters

`userId` - Sticker file owner.

`pngSticker` - PNG image with the sticker; must be up to 512 kB in size and fit in 512x512
square.

**Return**
[File](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html) Represents a file.

