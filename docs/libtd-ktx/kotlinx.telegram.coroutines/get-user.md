---
title: getUser - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getUser](./get-user.html)

# getUser

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getUser(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html)

Suspend function, which returns information about a user by their identifier. This is an offline
request if the current user is not a bot.

### Parameters

`userId` - User identifier.

**Return**
[User](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html) Represents a user.

