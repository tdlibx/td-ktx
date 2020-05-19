[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getChatMessageByDate](./get-chat-message-by-date.md)

# getChatMessageByDate

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getChatMessageByDate(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, date: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which returns the last message sent in a chat no later than the specified date.

### Parameters

`chatId` - Chat identifier.

`date` - Point in time (Unix timestamp) relative to which to search for messages.

**Return**
[Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

