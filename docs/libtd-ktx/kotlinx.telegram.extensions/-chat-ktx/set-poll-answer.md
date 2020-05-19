---
title: ChatKtx.setPollAnswer - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [setPollAnswer](./set-poll-answer.html)

# setPollAnswer

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.setPollAnswer(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, optionIds: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the user answer to a poll. A poll in quiz mode can be answered
only once.

### Parameters

`messageId` - Identifier of the message containing the poll.

`optionIds` - 0-based identifiers of answer options, chosen by the user. User can choose
more than 1 answer option only is the poll allows multiple answers.