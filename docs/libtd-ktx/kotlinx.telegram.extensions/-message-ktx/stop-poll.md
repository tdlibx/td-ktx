---
title: MessageKtx.stopPoll - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [MessageKtx](index.html) / [stopPoll](./stop-poll.html)

# stopPoll

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)`.stopPoll(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyMarkup: `[`ReplyMarkup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ReplyMarkup.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which stops a poll. A poll in a message can be stopped when the message has
canBeEdited flag set.

### Parameters

`chatId` - Identifier of the chat to which the poll belongs.

`replyMarkup` - The new message reply markup; for bots only.