---
title: getSupergroupMembers - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getSupergroupMembers](./get-supergroup-members.html)

# getSupergroupMembers

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getSupergroupMembers(supergroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, filter: `[`SupergroupMembersFilter`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SupergroupMembersFilter.html)`?, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ChatMembers`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatMembers.html)

Suspend function, which returns information about members or banned users in a supergroup or
channel. Can be used only if SupergroupFullInfo.canGetMembers == true; additionally, administrator
privileges may be required for some filters.

### Parameters

`supergroupId` - Identifier of the supergroup or channel.

`filter` - The type of users to return. By default, supergroupMembersRecent.

`offset` - Number of users to skip.

`limit` - The maximum number of users be returned; up to 200.

**Return**
[ChatMembers](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatMembers.html) Contains a list of chat members.

