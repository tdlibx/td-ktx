---
title: ChatKtx.removeTop - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [removeTop](./remove-top.html)

# removeTop

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.removeTop(category: `[`TopChatCategory`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TopChatCategory.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes a chat from the list of frequently used chats. Supported only
if the chat info database is enabled.

### Parameters

`category` - Category of frequently used chats.