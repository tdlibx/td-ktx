[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [unreadChatCountFlow](./unread-chat-count-flow.md)

# unreadChatCountFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.unreadChatCountFlow(): Flow<`[`UpdateUnreadChatCount`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateUnreadChatCount.html)`>`

emits [UpdateUnreadChatCount](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateUnreadChatCount.html) if number of unread chats, i.e. with unread messages or marked as
unread, has changed. This update is sent only if the message database is used.

