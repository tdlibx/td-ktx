---
title: UserKtx.createCall - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [UserKtx](index.html) / [createCall](./create-call.html)

# createCall

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.User.html)`.createCall(protocol: `[`CallProtocol`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallProtocol.html)`?): `[`CallId`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallId.html)

Suspend function, which creates a new call.

### Parameters

`protocol` - Description of the call protocols supported by the client.

**Return**
[TdApi.CallId](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallId.html) Contains the call identifier.

