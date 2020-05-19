[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getInlineQueryResults](./get-inline-query-results.md)

# getInlineQueryResults

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getInlineQueryResults(botUserId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userLocation: `[`Location`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Location.html)`?, query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, offset: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`InlineQueryResults`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InlineQueryResults.html)

Suspend function, which sends an inline query to a bot and returns its results. Returns an error
with code 502 if the bot fails to answer the query before the query timeout expires.

### Parameters

`botUserId` - The identifier of the target bot.

`chatId` - Identifier of the chat where the query was sent.

`userLocation` - Location of the user, only if needed.

`query` - Text of the query.

`offset` - Offset of the first entry to return.

**Return**
[InlineQueryResults](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InlineQueryResults.html) Represents the results of the inline query. Use
sendInlineQueryResultMessage to send the result of the query.

