---
title: setChatLocation - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setChatLocation](./set-chat-location.html)

# setChatLocation

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setChatLocation(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, location: `[`ChatLocation`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatLocation.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the location of a chat. Available only for some location-based
supergroups, use supergroupFullInfo.canSetLocation to check whether the method is allowed to use.

### Parameters

`chatId` - Chat identifier.

`location` - New location for the chat; must be valid and not null.