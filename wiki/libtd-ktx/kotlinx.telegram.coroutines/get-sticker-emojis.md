[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getStickerEmojis](./get-sticker-emojis.md)

# getStickerEmojis

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getStickerEmojis(sticker: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputFile.html)`?): `[`Emojis`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Emojis.html)

Suspend function, which returns emoji corresponding to a sticker. The list is only for
informational purposes, because a sticker is always sent with a fixed emoji from the corresponding
Sticker object.

### Parameters

`sticker` - Sticker file identifier.

**Return**
[Emojis](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Emojis.html) Represents a list of emoji.

