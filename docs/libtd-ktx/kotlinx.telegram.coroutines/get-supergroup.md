---
title: getSupergroup - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getSupergroup](./get-supergroup.html)

# getSupergroup

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getSupergroup(supergroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Supergroup.html)

Suspend function, which returns information about a supergroup or a channel by its identifier.
This is an offline request if the current user is not a bot.

### Parameters

`supergroupId` - Supergroup or channel identifier.

**Return**
[Supergroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Supergroup.html) Represents a supergroup or channel with zero or more members (subscribers in
the case of channels). From the point of view of the system, a channel is a special kind of a
supergroup: only administrators can post and see the list of members, and posts from all
administrators use the name and photo of the channel instead of individual names and profile photos.
Unlike supergroups, channels can have an unlimited number of subscribers.

