[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchCallMessages](./search-call-messages.md)

# searchCallMessages

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchCallMessages(fromMessageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, onlyMissed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Messages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Messages.html)

Suspend function, which searches for call messages. Returns the results in reverse chronological
order (i. e., in order of decreasing messageId). For optimal performance the number of returned
messages is chosen by the library.

### Parameters

`fromMessageId` - Identifier of the message from which to search; use 0 to get results from
the last message.

`limit` - The maximum number of messages to be returned; up to 100. Fewer messages may be
returned than specified by the limit, even if the end of the message history has not been reached.

`onlyMissed` - If true, returns only messages with missed calls.

**Return**
[Messages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Messages.html) Contains a list of messages.

