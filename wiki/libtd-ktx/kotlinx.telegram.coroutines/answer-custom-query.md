[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [answerCustomQuery](./answer-custom-query.md)

# answerCustomQuery

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.answerCustomQuery(customQueryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, data: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which answers a custom query; for bots only.

### Parameters

`customQueryId` - Identifier of a custom query.

`data` - JSON-serialized answer to the query.