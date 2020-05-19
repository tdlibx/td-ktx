[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [createCall](./create-call.md)

# createCall

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.createCall(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, protocol: `[`CallProtocol`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallProtocol.html)`?): `[`CallId`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallId.html)

Suspend function, which creates a new call.

### Parameters

`userId` - Identifier of the user to be called.

`protocol` - Description of the call protocols supported by the client.

**Return**
[CallId](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallId.html) Contains the call identifier.

