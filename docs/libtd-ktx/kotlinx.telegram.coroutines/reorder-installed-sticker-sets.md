---
title: reorderInstalledStickerSets - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [reorderInstalledStickerSets](./reorder-installed-sticker-sets.html)

# reorderInstalledStickerSets

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.reorderInstalledStickerSets(isMasks: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, stickerSetIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the order of installed sticker sets.

### Parameters

`isMasks` - Pass true to change the order of mask sticker sets; pass false to change the order
of ordinary sticker sets.

`stickerSetIds` - Identifiers of installed sticker sets in the new correct order.