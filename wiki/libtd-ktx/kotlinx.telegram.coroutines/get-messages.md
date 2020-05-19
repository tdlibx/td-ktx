[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getMessages](./get-messages.md)

# getMessages

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getMessages(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Messages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Messages.html)

Suspend function, which returns information about messages. If a message is not found, returns
null on the corresponding position of the result.

### Parameters

`chatId` - Identifier of the chat the messages belong to.

`messageIds` - Identifiers of the messages to get.

**Return**
[Messages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Messages.html) Contains a list of messages.

