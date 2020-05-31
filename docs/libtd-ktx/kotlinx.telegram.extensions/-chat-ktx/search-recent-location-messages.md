---
title: ChatKtx.searchRecentLocationMessages - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [searchRecentLocationMessages](./search-recent-location-messages.html)

# searchRecentLocationMessages

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.searchRecentLocationMessages(limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Messages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Messages.html)

Suspend function, which returns information about the recent locations of chat members that
were sent to the chat. Returns up to 1 location message per user.

### Parameters

`limit` - The maximum number of messages to be returned.

**Return**
[TdApi.Messages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Messages.html) Contains a list of messages.

