[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getChat](./get-chat.md)

# getChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getChat(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)

Suspend function, which returns information about a chat by its identifier, this is an offline
request if the current user is not a bot.

### Parameters

`chatId` - Chat identifier.

**Return**
[Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

