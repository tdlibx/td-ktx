[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [SupergroupKtx](index.md) / [setStickerSet](./set-sticker-set.md)

# setStickerSet

`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Supergroup.html)`.setStickerSet(stickerSetId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the sticker set of a supergroup; requires canChangeInfo rights.

### Parameters

`stickerSetId` - New value of the supergroup sticker set identifier. Use 0 to remove the
supergroup sticker set.