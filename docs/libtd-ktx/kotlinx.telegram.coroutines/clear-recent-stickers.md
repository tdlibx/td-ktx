---
title: clearRecentStickers - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [clearRecentStickers](./clear-recent-stickers.html)

# clearRecentStickers

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.clearRecentStickers(isAttached: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which clears the list of recently used stickers.

### Parameters

`isAttached` - Pass true to clear the list of stickers recently attached to photo or video
files; pass false to clear the list of recently sent stickers.