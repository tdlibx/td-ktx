---
title: ChatKtx.editMessageSchedulingState - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [editMessageSchedulingState](./edit-message-scheduling-state.html)

# editMessageSchedulingState

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.editMessageSchedulingState(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, schedulingState: `[`MessageSchedulingState`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/MessageSchedulingState.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which edits the time when a scheduled message will be sent. Scheduling state
of all messages in the same album or forwarded together with the message will be also changed.

### Parameters

`messageId` - Identifier of the message.

`schedulingState` - The new message scheduling state. Pass null to send the message
immediately.