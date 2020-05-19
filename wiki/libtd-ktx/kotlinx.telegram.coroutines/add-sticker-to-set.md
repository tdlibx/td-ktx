[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [addStickerToSet](./add-sticker-to-set.md)

# addStickerToSet

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.addStickerToSet(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, sticker: `[`InputSticker`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputSticker.html)`?): `[`StickerSet`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StickerSet.html)

Suspend function, which adds a new sticker to a set; for bots only. Returns the sticker set.

### Parameters

`userId` - Sticker set owner.

`name` - Sticker set name.

`sticker` - Sticker to add to the set.

**Return**
[StickerSet](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StickerSet.html) Represents a sticker set.

