[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getInstalledStickerSets](./get-installed-sticker-sets.md)

# getInstalledStickerSets

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getInstalledStickerSets(isMasks: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`StickerSets`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StickerSets.html)

Suspend function, which returns a list of installed sticker sets.

### Parameters

`isMasks` - Pass true to return mask sticker sets; pass false to return ordinary sticker sets.

**Return**
[StickerSets](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StickerSets.html) Represents a list of sticker sets.

