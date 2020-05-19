[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [answerInlineQuery](./answer-inline-query.md)

# answerInlineQuery

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.answerInlineQuery(inlineQueryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, isPersonal: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, results: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`InputInlineQueryResult`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputInlineQueryResult.html)`>?, cacheTime: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, nextOffset: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, switchPmText: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, switchPmParameter: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets the result of an inline query; for bots only.

### Parameters

`inlineQueryId` - Identifier of the inline query.

`isPersonal` - True, if the result of the query can be cached for the specified user.

`results` - The results of the query.

`cacheTime` - Allowed time to cache the results of the query, in seconds.

`nextOffset` - Offset for the next inline query; pass an empty string if there are no more
results.

`switchPmText` - If non-empty, this text should be shown on the button that opens a private
chat with the bot and sends a start message to the bot with the parameter switchPmParameter.

`switchPmParameter` - The parameter for the bot start message.