[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setStickerPositionInSet](./set-sticker-position-in-set.md)

# setStickerPositionInSet

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setStickerPositionInSet(sticker: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputFile.html)`?, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the position of a sticker in the set to which it belongs; for
bots only. The sticker set must have been created by the bot.

### Parameters

`sticker` - Sticker.

`position` - New position of the sticker in the set, zero-based.