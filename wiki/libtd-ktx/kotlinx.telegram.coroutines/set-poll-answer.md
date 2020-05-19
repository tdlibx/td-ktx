[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setPollAnswer](./set-poll-answer.md)

# setPollAnswer

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setPollAnswer(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, optionIds: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the user answer to a poll. A poll in quiz mode can be answered
only once.

### Parameters

`chatId` - Identifier of the chat to which the poll belongs.

`messageId` - Identifier of the message containing the poll.

`optionIds` - 0-based identifiers of answer options, chosen by the user. User can choose more
than 1 answer option only is the poll allows multiple answers.