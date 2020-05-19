[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [removeRecentSticker](./remove-recent-sticker.md)

# removeRecentSticker

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.removeRecentSticker(isAttached: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, sticker: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputFile.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes a sticker from the list of recently used stickers.

### Parameters

`isAttached` - Pass true to remove the sticker from the list of stickers recently attached to
photo or video files; pass false to remove the sticker from the list of recently sent stickers.

`sticker` - Sticker file to delete.