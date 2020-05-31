---
title: removeStickerFromSet - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [removeStickerFromSet](./remove-sticker-from-set.html)

# removeStickerFromSet

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.removeStickerFromSet(sticker: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputFile.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes a sticker from the set to which it belongs; for bots only. The
sticker set must have been created by the bot.

### Parameters

`sticker` - Sticker.