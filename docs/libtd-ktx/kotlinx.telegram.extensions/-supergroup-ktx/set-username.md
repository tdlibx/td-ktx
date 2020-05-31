---
title: SupergroupKtx.setUsername - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [SupergroupKtx](index.html) / [setUsername](./set-username.html)

# setUsername

`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.setUsername(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the username of a supergroup or channel, requires owner
privileges in the supergroup or channel.

### Parameters

`username` - New value of the username. Use an empty string to remove the username.