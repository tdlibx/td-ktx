---
title: addFavoriteSticker - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [addFavoriteSticker](./add-favorite-sticker.html)

# addFavoriteSticker

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.addFavoriteSticker(sticker: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputFile.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds a new sticker to the list of favorite stickers. The new sticker is
added to the top of the list. If the sticker was already in the list, it is removed from the list
first. Only stickers belonging to a sticker set can be added to this list.

### Parameters

`sticker` - Sticker file to add.