---
title: searchChatsNearby - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [searchChatsNearby](./search-chats-nearby.html)

# searchChatsNearby

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.searchChatsNearby(location: `[`Location`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Location.html)`?): `[`ChatsNearby`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatsNearby.html)

Suspend function, which returns a list of users and location-based supergroups nearby. The list
of users nearby will be updated for 60 seconds after the request by the updates updateUsersNearby.
The request should be sent again every 25 seconds with adjusted location to not miss new chats.

### Parameters

`location` - Current user location.

**Return**
[ChatsNearby](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatsNearby.html) Represents a list of chats located nearby.

