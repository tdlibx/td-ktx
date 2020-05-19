[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [viewTrendingStickerSets](./view-trending-sticker-sets.md)

# viewTrendingStickerSets

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.viewTrendingStickerSets(stickerSetIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs the server that some trending sticker sets have been viewed by
the user.

### Parameters

`stickerSetIds` - Identifiers of viewed trending sticker sets.