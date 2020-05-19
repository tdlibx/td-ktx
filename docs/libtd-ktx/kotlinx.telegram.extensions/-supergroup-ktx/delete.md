---
title: SupergroupKtx.delete - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [SupergroupKtx](index.html) / [delete](./delete.html)

# delete

`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Supergroup.html)`.delete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes a supergroup or channel along with all messages in the
corresponding chat. This will release the supergroup or channel username and remove all members;
requires owner privileges in the supergroup or channel. Chats with more than 1000 members can't be
deleted using this method.

