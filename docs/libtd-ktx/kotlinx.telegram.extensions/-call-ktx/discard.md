---
title: CallKtx.discard - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [CallKtx](index.html) / [discard](./discard.html)

# discard

`open suspend fun `[`Call`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Call.html)`.discard(isDisconnected: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, duration: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, connectionId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which discards a call.

### Parameters

`isDisconnected` - True, if the user was disconnected.

`duration` - The call duration, in seconds.

`connectionId` - Identifier of the connection used during the call.