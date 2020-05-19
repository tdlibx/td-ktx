[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [resendMessages](./resend-messages.md)

# resendMessages

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.resendMessages(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Messages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Messages.html)

Suspend function, which resends messages which failed to send. Can be called only for messages
for which messageSendingStateFailed.canRetry is true and after specified in
messageSendingStateFailed.retryAfter time passed. If a message is re-sent, the corresponding failed
to send message is deleted. Returns the sent messages in the same order as the message identifiers
passed in messageIds. If a message can't be re-sent, null will be returned instead of the message.

### Parameters

`chatId` - Identifier of the chat to send messages.

`messageIds` - Identifiers of the messages to resend. Message identifiers must be in a
strictly increasing order.

**Return**
[Messages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Messages.html) Contains a list of messages.

