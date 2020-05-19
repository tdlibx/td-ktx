[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getArchivedStickerSets](./get-archived-sticker-sets.md)

# getArchivedStickerSets

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getArchivedStickerSets(isMasks: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, offsetStickerSetId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`StickerSets`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.StickerSets.html)

Suspend function, which returns a list of archived sticker sets.

### Parameters

`isMasks` - Pass true to return mask stickers sets; pass false to return ordinary sticker
sets.

`offsetStickerSetId` - Identifier of the sticker set from which to return the result.

`limit` - The maximum number of sticker sets to return.

**Return**
[StickerSets](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.StickerSets.html) Represents a list of sticker sets.

