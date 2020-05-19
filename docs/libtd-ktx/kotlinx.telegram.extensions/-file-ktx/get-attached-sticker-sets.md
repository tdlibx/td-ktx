---
title: FileKtx.getAttachedStickerSets - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [FileKtx](index.html) / [getAttachedStickerSets](./get-attached-sticker-sets.html)

# getAttachedStickerSets

`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/File.html)`.getAttachedStickerSets(): `[`StickerSets`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StickerSets.html)

Suspend function, which returns a list of sticker sets attached to a file. Currently only
photos and videos can have attached sticker sets.

**Return**
[TdApi.StickerSets](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StickerSets.html) Represents a list of sticker sets.

