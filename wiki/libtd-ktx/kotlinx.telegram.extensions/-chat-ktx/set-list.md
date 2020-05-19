[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [setList](./set-list.md)

# setList

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.setList(chatList: `[`ChatList`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatList.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which moves a chat to a different chat list. Current chat list of the chat
must ne non-null.

### Parameters

`chatList` - New chat list of the chat.