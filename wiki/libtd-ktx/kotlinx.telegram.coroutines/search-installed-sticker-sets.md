[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchInstalledStickerSets](./search-installed-sticker-sets.md)

# searchInstalledStickerSets

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchInstalledStickerSets(isMasks: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`StickerSets`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.StickerSets.html)

Suspend function, which searches for installed sticker sets by looking for specified query in
their title and name.

### Parameters

`isMasks` - Pass true to return mask sticker sets; pass false to return ordinary sticker sets.

`query` - Query to search for.

`limit` - The maximum number of sticker sets to return.

**Return**
[StickerSets](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.StickerSets.html) Represents a list of sticker sets.

