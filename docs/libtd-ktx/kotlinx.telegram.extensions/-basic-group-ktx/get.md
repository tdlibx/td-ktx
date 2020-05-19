---
title: BasicGroupKtx.get - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [BasicGroupKtx](index.html) / [get](./get.html)

# get

`open suspend fun `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/BasicGroup.html)`.get(): `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/BasicGroup.html)

Suspend function, which returns information about a basic group by its identifier. This is an
offline request if the current user is not a bot.

**Return**
[TdApi.BasicGroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/BasicGroup.html) Represents a basic group of 0-200 users (must be upgraded to a
supergroup to accommodate more than 200 users).

