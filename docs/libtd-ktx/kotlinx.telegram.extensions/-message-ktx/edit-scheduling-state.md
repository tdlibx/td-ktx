---
title: MessageKtx.editSchedulingState - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [MessageKtx](index.html) / [editSchedulingState](./edit-scheduling-state.html)

# editSchedulingState

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.editSchedulingState(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, schedulingState: `[`MessageSchedulingState`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/MessageSchedulingState.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which edits the time when a scheduled message will be sent. Scheduling state
of all messages in the same album or forwarded together with the message will be also changed.

### Parameters

`chatId` - The chat the message belongs to.

`schedulingState` - The new message scheduling state. Pass null to send the message
immediately.