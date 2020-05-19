[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [addLocalMessage](./add-local-message.md)

# addLocalMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.addLocalMessage(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, senderUserId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, replyToMessageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, disableNotification: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, inputMessageContent: `[`InputMessageContent`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputMessageContent.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which adds a local message to a chat. The message is persistent across
application restarts only if the message database is used. Returns the added message.

### Parameters

`chatId` - Target chat.

`senderUserId` - Identifier of the user who will be shown as the sender of the message; may be
0 for channel posts.

`replyToMessageId` - Identifier of the message to reply to or 0.

`disableNotification` - Pass true to disable notification for the message.

`inputMessageContent` - The content of the message to be added.

**Return**
[Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

