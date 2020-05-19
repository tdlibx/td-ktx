[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [UserKtx](index.md) / [createNewStickerSet](./create-new-sticker-set.md)

# createNewStickerSet

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html)`.createNewStickerSet(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, isMasks: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, stickers: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`InputSticker`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputSticker.html)`>?): `[`StickerSet`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StickerSet.html)

Suspend function, which creates a new sticker set; for bots only. Returns the newly created
sticker set.

### Parameters

`title` - Sticker set title; 1-64 characters.

`name` - Sticker set name. Can contain only English letters, digits and underscores. Must
end with *&quot;*by*&amp;lt;bot username&amp;gt;&amp;quot;* (*&amp;lt;botUsername&amp;gt;* is case insensitive); 1-64
characters.

`isMasks` - True, if stickers are masks.

`stickers` - List of stickers to be added to the set.

**Return**
[TdApi.StickerSet](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StickerSet.html) Represents a sticker set.

