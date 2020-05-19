[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchEmojis](./search-emojis.md)

# searchEmojis

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchEmojis(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, exactMatch: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, inputLanguageCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Emojis`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Emojis.html)

Suspend function, which searches for emojis by keywords. Supported only if the file database is
enabled.

### Parameters

`text` - Text to search for.

`exactMatch` - True, if only emojis, which exactly match text needs to be returned.

`inputLanguageCode` - IETF language tag of the user's input language; may be empty if unknown.

**Return**
[Emojis](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Emojis.html) Represents a list of emoji.

