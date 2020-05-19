[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setChatChatList](./set-chat-chat-list.md)

# setChatChatList

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setChatChatList(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, chatList: `[`ChatList`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatList.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which moves a chat to a different chat list. Current chat list of the chat must
ne non-null.

### Parameters

`chatId` - Chat identifier.

`chatList` - New chat list of the chat.