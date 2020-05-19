[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [UserKtx](index.md) / [getGroupsInCommon](./get-groups-in-common.md)

# getGroupsInCommon

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html)`.getGroupsInCommon(offsetChatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Chats`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chats.html)

Suspend function, which returns a list of common group chats with a given user. Chats are
sorted by their type and creation date.

### Parameters

`offsetChatId` - Chat identifier starting from which to return chats; use 0 for the first
request.

`limit` - The maximum number of chats to be returned; up to 100.

**Return**
[TdApi.Chats](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chats.html) Represents a list of chats.

