---
title: UserKtx.addStickerToSet - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [UserKtx](index.html) / [addStickerToSet](./add-sticker-to-set.html)

# addStickerToSet

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.User.html)`.addStickerToSet(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, sticker: `[`InputSticker`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputSticker.html)`?): `[`StickerSet`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.StickerSet.html)

Suspend function, which adds a new sticker to a set; for bots only. Returns the sticker set.

### Parameters

`name` - Sticker set name.

`sticker` - Sticker to add to the set.

**Return**
[TdApi.StickerSet](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.StickerSet.html) Represents a sticker set.

