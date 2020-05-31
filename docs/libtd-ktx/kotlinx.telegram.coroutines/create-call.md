---
title: createCall - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [createCall](./create-call.html)

# createCall

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.createCall(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, protocol: `[`CallProtocol`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallProtocol.html)`?): `[`CallId`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallId.html)

Suspend function, which creates a new call.

### Parameters

`userId` - Identifier of the user to be called.

`protocol` - Description of the call protocols supported by the client.

**Return**
[CallId](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallId.html) Contains the call identifier.

