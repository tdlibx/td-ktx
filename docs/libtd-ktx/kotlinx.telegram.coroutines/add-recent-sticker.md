---
title: addRecentSticker - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [addRecentSticker](./add-recent-sticker.html)

# addRecentSticker

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.addRecentSticker(isAttached: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, sticker: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputFile.html)`?): `[`Stickers`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Stickers.html)

Suspend function, which manually adds a new sticker to the list of recently used stickers. The
new sticker is added to the top of the list. If the sticker was already in the list, it is removed
from the list first. Only stickers belonging to a sticker set can be added to this list.

### Parameters

`isAttached` - Pass true to add the sticker to the list of stickers recently attached to photo
or video files; pass false to add the sticker to the list of recently sent stickers.

`sticker` - Sticker file to add.

**Return**
[Stickers](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Stickers.html) Represents a list of stickers.

