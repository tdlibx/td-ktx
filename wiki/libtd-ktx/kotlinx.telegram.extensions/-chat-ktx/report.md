[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [report](./report.md)

# report

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.report(reason: `[`ChatReportReason`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatReportReason.html)`?, messageIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which reports a chat to the Telegram moderators. Supported only for
supergroups, channels, or private chats with bots, since other chats can't be checked by
moderators, or when the report is done from the chat action bar.

### Parameters

`reason` - The reason for reporting the chat.

`messageIds` - Identifiers of reported messages, if any.