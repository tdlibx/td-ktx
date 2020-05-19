[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getCallbackQueryAnswer](./get-callback-query-answer.md)

# getCallbackQueryAnswer

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getCallbackQueryAnswer(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, payload: `[`CallbackQueryPayload`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallbackQueryPayload.html)`?): `[`CallbackQueryAnswer`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallbackQueryAnswer.html)

Suspend function, which sends a callback query to a bot and returns an answer. Returns an error
with code 502 if the bot fails to answer the query before the query timeout expires.

### Parameters

`chatId` - Identifier of the chat with the message.

`messageId` - Identifier of the message from which the query originated.

`payload` - Query payload.

**Return**
[CallbackQueryAnswer](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallbackQueryAnswer.html) Contains a bot's answer to a callback query.

