[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchChatsNearby](./search-chats-nearby.md)

# searchChatsNearby

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchChatsNearby(location: `[`Location`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Location.html)`?): `[`ChatsNearby`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatsNearby.html)

Suspend function, which returns a list of users and location-based supergroups nearby. The list
of users nearby will be updated for 60 seconds after the request by the updates updateUsersNearby.
The request should be sent again every 25 seconds with adjusted location to not miss new chats.

### Parameters

`location` - Current user location.

**Return**
[ChatsNearby](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatsNearby.html) Represents a list of chats located nearby.

