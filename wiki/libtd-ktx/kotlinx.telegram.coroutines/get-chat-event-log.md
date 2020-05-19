[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getChatEventLog](./get-chat-event-log.md)

# getChatEventLog

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getChatEventLog(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, fromEventId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, filters: `[`ChatEventLogFilters`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatEventLogFilters.html)`?, userIds: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`?): `[`ChatEvents`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatEvents.html)

Suspend function, which returns a list of service actions taken by chat members and
administrators in the last 48 hours. Available only for supergroups and channels. Requires
administrator rights. Returns results in reverse chronological order (i. e., in order of decreasing
eventId).

### Parameters

`chatId` - Chat identifier.

`query` - Search query by which to filter events.

`fromEventId` - Identifier of an event from which to return results. Use 0 to get results from
the latest events.

`limit` - The maximum number of events to return; up to 100.

`filters` - The types of events to return. By default, all types will be returned.

`userIds` - User identifiers by which to filter events. By default, events relating to all
users will be returned.

**Return**
[ChatEvents](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatEvents.html) Contains a list of chat events.

