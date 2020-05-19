[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchStickerSets](./search-sticker-sets.md)

# searchStickerSets

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchStickerSets(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`StickerSets`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.StickerSets.html)

Suspend function, which searches for ordinary sticker sets by looking for specified query in
their title and name. Excludes installed sticker sets from the results.

### Parameters

`query` - Query to search for.

**Return**
[StickerSets](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.StickerSets.html) Represents a list of sticker sets.

