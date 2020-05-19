[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchStickers](./search-stickers.md)

# searchStickers

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchStickers(emoji: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Stickers`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Stickers.html)

Suspend function, which searches for stickers from public sticker sets that correspond to a given
emoji.

### Parameters

`emoji` - String representation of emoji; must be non-empty.

`limit` - The maximum number of stickers to be returned.

**Return**
[Stickers](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Stickers.html) Represents a list of stickers.

