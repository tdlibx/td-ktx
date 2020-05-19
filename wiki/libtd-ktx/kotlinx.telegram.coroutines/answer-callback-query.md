[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [answerCallbackQuery](./answer-callback-query.md)

# answerCallbackQuery

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.answerCallbackQuery(callbackQueryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, showAlert: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, cacheTime: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets the result of a callback query; for bots only.

### Parameters

`callbackQueryId` - Identifier of the callback query.

`text` - Text of the answer.

`showAlert` - If true, an alert should be shown to the user instead of a toast notification.

`url` - URL to be opened.

`cacheTime` - Time during which the result of the query can be cached, in seconds.