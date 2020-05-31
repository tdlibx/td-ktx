---
title: getStickerEmojis - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getStickerEmojis](./get-sticker-emojis.html)

# getStickerEmojis

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getStickerEmojis(sticker: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputFile.html)`?): `[`Emojis`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Emojis.html)

Suspend function, which returns emoji corresponding to a sticker. The list is only for
informational purposes, because a sticker is always sent with a fixed emoji from the corresponding
Sticker object.

### Parameters

`sticker` - Sticker file identifier.

**Return**
[Emojis](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Emojis.html) Represents a list of emoji.

