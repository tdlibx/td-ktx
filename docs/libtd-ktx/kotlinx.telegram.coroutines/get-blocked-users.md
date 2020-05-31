---
title: getBlockedUsers - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getBlockedUsers](./get-blocked-users.html)

# getBlockedUsers

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getBlockedUsers(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Users`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Users.html)

Suspend function, which returns users that were blocked by the current user.

### Parameters

`offset` - Number of users to skip in the result; must be non-negative.

`limit` - The maximum number of users to return; up to 100.

**Return**
[Users](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Users.html) Represents a list of users.

