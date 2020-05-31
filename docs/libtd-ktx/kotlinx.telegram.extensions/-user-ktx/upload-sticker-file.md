---
title: UserKtx.uploadStickerFile - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [UserKtx](index.html) / [uploadStickerFile](./upload-sticker-file.html)

# uploadStickerFile

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.User.html)`.uploadStickerFile(pngSticker: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputFile.html)`?): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)

Suspend function, which uploads a PNG image with a sticker; for bots only; returns the uploaded
file.

### Parameters

`pngSticker` - PNG image with the sticker; must be up to 512 kB in size and fit in 512x512
square.

**Return**
[TdApi.File](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html) Represents a file.

