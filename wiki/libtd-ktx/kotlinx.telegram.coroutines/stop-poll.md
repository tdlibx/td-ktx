[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [stopPoll](./stop-poll.md)

# stopPoll

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.stopPoll(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ReplyMarkup.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which stops a poll. A poll in a message can be stopped when the message has
canBeEdited flag set.

### Parameters

`chatId` - Identifier of the chat to which the poll belongs.

`messageId` - Identifier of the message containing the poll.

`replyMarkup` - The new message reply markup; for bots only.