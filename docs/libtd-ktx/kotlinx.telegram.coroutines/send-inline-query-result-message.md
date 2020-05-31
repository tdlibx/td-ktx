---
title: sendInlineQueryResultMessage - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [sendInlineQueryResultMessage](./send-inline-query-result-message.html)

# sendInlineQueryResultMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.sendInlineQueryResultMessage(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, replyToMessageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, options: `[`SendMessageOptions`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SendMessageOptions.html)`?, queryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, resultId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, hideViaBot: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which sends the result of an inline query as a message. Returns the sent
message. Always clears a chat draft message.

### Parameters

`chatId` - Target chat.

`replyToMessageId` - Identifier of a message to reply to or 0.

`options` - Options to be used to send the message.

`queryId` - Identifier of the inline query.

`resultId` - Identifier of the inline result.

`hideViaBot` - If true, there will be no mention of a bot, via which the message is sent. Can
be used only for bots GetOption(&amp;quot;animation_search_bot_username&amp;quot;),
GetOption(&amp;quot;photo_search_bot_username&amp;quot;) and
GetOption(&amp;quot;venue_search_bot_username&amp;quot;).

**Return**
[Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

