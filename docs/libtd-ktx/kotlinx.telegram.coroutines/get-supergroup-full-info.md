---
title: getSupergroupFullInfo - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getSupergroupFullInfo](./get-supergroup-full-info.html)

# getSupergroupFullInfo

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getSupergroupFullInfo(supergroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`SupergroupFullInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SupergroupFullInfo.html)

Suspend function, which returns full information about a supergroup or a channel by its
identifier, cached for up to 1 minute.

### Parameters

`supergroupId` - Supergroup or channel identifier.

**Return**
[SupergroupFullInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SupergroupFullInfo.html) Contains full information about a supergroup or channel.

