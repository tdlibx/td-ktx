[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [SupergroupKtx](index.md) / [getMembers](./get-members.md)

# getMembers

`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Supergroup.html)`.getMembers(filter: `[`SupergroupMembersFilter`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/SupergroupMembersFilter.html)`?, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ChatMembers`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatMembers.html)

Suspend function, which returns information about members or banned users in a supergroup or
channel. Can be used only if SupergroupFullInfo.canGetMembers == true; additionally, administrator
privileges may be required for some filters.

### Parameters

`filter` - The type of users to return. By default, supergroupMembersRecent.

`offset` - Number of users to skip.

`limit` - The maximum number of users be returned; up to 200.

**Return**
[TdApi.ChatMembers](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatMembers.html) Contains a list of chat members.

