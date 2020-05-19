[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setPinnedChats](./set-pinned-chats.md)

# setPinnedChats

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setPinnedChats(chatList: `[`ChatList`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatList.html)`?, chatIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the order of pinned chats.

### Parameters

`chatList` - Chat list in which to change the order of pinned chats.

`chatIds` - The new list of pinned chats.