[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [MessageKtx](index.md) / [setPollAnswer](./set-poll-answer.md)

# setPollAnswer

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.setPollAnswer(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, optionIds: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the user answer to a poll. A poll in quiz mode can be answered
only once.

### Parameters

`chatId` - Identifier of the chat to which the poll belongs.

`optionIds` - 0-based identifiers of answer options, chosen by the user. User can choose
more than 1 answer option only is the poll allows multiple answers.