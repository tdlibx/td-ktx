[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getMessageLocally](./get-message-locally.md)

# getMessageLocally

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getMessageLocally(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which returns information about a message, if it is available locally without
sending network request. This is an offline request.

### Parameters

`chatId` - Identifier of the chat the message belongs to.

`messageId` - Identifier of the message to get.

**Return**
[Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

