---
title: reportChat - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [reportChat](./report-chat.html)

# reportChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.reportChat(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, reason: `[`ChatReportReason`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatReportReason.html)`?, messageIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which reports a chat to the Telegram moderators. Supported only for
supergroups, channels, or private chats with bots, since other chats can't be checked by moderators,
or when the report is done from the chat action bar.

### Parameters

`chatId` - Chat identifier.

`reason` - The reason for reporting the chat.

`messageIds` - Identifiers of reported messages, if any.