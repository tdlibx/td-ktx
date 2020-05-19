[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getStickers](./get-stickers.md)

# getStickers

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getStickers(emoji: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Stickers`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Stickers.html)

Suspend function, which returns stickers from the installed sticker sets that correspond to a
given emoji. If the emoji is not empty, favorite and recently used stickers may also be returned.

### Parameters

`emoji` - String representation of emoji. If empty, returns all known installed stickers.

`limit` - The maximum number of stickers to be returned.

**Return**
[Stickers](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Stickers.html) Represents a list of stickers.

