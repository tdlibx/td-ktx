[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [MessageKtx](index.md) / [getLocally](./get-locally.md)

# getLocally

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.getLocally(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)

Suspend function, which returns information about a message, if it is available locally without
sending network request. This is an offline request.

### Parameters

`chatId` - Identifier of the chat the message belongs to.

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html) Describes a message.

