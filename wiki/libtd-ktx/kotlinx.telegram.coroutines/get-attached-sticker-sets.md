[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getAttachedStickerSets](./get-attached-sticker-sets.md)

# getAttachedStickerSets

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getAttachedStickerSets(fileId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`StickerSets`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StickerSets.html)

Suspend function, which returns a list of sticker sets attached to a file. Currently only photos
and videos can have attached sticker sets.

### Parameters

`fileId` - File identifier.

**Return**
[StickerSets](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StickerSets.html) Represents a list of sticker sets.

