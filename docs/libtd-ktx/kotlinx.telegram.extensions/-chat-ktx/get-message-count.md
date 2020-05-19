---
title: ChatKtx.getMessageCount - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [getMessageCount](./get-message-count.html)

# getMessageCount

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.getMessageCount(filter: `[`SearchMessagesFilter`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SearchMessagesFilter.html)`?, returnLocal: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Count`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Count.html)

Suspend function, which returns approximate number of messages of the specified type in the
chat.

### Parameters

`filter` - Filter for message content; searchMessagesFilterEmpty is unsupported in this
function.

`returnLocal` - If true, returns count that is available locally without sending network
requests, returning -1 if the number of messages is unknown.

**Return**
[TdApi.Count](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Count.html) Contains a counter.

