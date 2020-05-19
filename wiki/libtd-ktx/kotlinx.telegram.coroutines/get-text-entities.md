[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getTextEntities](./get-text-entities.md)

# getTextEntities

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getTextEntities(text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`TextEntities`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TextEntities.html)

Suspend function, which returns all entities (mentions, hashtags, cashtags, bot commands, URLs,
and email addresses) contained in the text. This is an offline method. Can be called before
authorization. Can be called synchronously.

### Parameters

`text` - The text in which to look for entites.

**Return**
[TextEntities](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TextEntities.html) Contains a list of text entities.

