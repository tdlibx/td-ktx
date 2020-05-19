[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getRecentStickers](./get-recent-stickers.md)

# getRecentStickers

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getRecentStickers(isAttached: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Stickers`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Stickers.html)

Suspend function, which returns a list of recently used stickers.

### Parameters

`isAttached` - Pass true to return stickers and masks that were recently attached to photos or
video files; pass false to return recently sent stickers.

**Return**
[Stickers](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Stickers.html) Represents a list of stickers.
