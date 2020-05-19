---
title: editMessageSchedulingState - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [editMessageSchedulingState](./edit-message-scheduling-state.html)

# editMessageSchedulingState

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.editMessageSchedulingState(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, schedulingState: `[`MessageSchedulingState`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/MessageSchedulingState.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which edits the time when a scheduled message will be sent. Scheduling state of
all messages in the same album or forwarded together with the message will be also changed.

### Parameters

`chatId` - The chat the message belongs to.

`messageId` - Identifier of the message.

`schedulingState` - The new message scheduling state. Pass null to send the message
immediately.