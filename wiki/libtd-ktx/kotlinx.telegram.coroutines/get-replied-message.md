[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getRepliedMessage](./get-replied-message.md)

# getRepliedMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getRepliedMessage(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which returns information about a message that is replied by given message.

### Parameters

`chatId` - Identifier of the chat the message belongs to.

`messageId` - Identifier of the message reply to which get.

**Return**
[Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

