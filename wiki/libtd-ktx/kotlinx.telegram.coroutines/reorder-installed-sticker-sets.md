[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [reorderInstalledStickerSets](./reorder-installed-sticker-sets.md)

# reorderInstalledStickerSets

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.reorderInstalledStickerSets(isMasks: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, stickerSetIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the order of installed sticker sets.

### Parameters

`isMasks` - Pass true to change the order of mask sticker sets; pass false to change the order
of ordinary sticker sets.

`stickerSetIds` - Identifiers of installed sticker sets in the new correct order.