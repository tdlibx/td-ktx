---
title: viewTrendingStickerSets - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [viewTrendingStickerSets](./view-trending-sticker-sets.html)

# viewTrendingStickerSets

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.viewTrendingStickerSets(stickerSetIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs the server that some trending sticker sets have been viewed by
the user.

### Parameters

`stickerSetIds` - Identifiers of viewed trending sticker sets.