[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getChatPinnedMessage](./get-chat-pinned-message.md)

# getChatPinnedMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getChatPinnedMessage(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which returns information about a pinned chat message.

### Parameters

`chatId` - Identifier of the chat the message belongs to.

**Return**
[Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

