[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getChatHistory](./get-chat-history.md)

# getChatHistory

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getChatHistory(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, fromMessageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, onlyLocal: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Messages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Messages.html)

Suspend function, which returns messages in a chat. The messages are returned in a reverse
chronological order (i.e., in order of decreasing messageId). For optimal performance the number of
returned messages is chosen by the library. This is an offline request if onlyLocal is true.

### Parameters

`chatId` - Chat identifier.

`fromMessageId` - Identifier of the message starting from which history must be fetched; use 0
to get results from the last message.

`offset` - Specify 0 to get results from exactly the fromMessageId or a negative offset up to
99 to get additionally some newer messages.

`limit` - The maximum number of messages to be returned; must be positive and can't be greater
than 100. If the offset is negative, the limit must be greater or equal to -offset. Fewer messages
may be returned than specified by the limit, even if the end of the message history has not been
reached.

`onlyLocal` - If true, returns only messages that are available locally without sending
network requests.

**Return**
[Messages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Messages.html) Contains a list of messages.

