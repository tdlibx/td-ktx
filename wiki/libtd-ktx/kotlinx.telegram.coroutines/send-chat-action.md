[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [sendChatAction](./send-chat-action.md)

# sendChatAction

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.sendChatAction(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, action: `[`ChatAction`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatAction.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sends a notification about user activity in a chat.

### Parameters

`chatId` - Chat identifier.

`action` - The action description.