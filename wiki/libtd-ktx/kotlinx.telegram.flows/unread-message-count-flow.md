[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [unreadMessageCountFlow](./unread-message-count-flow.md)

# unreadMessageCountFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.unreadMessageCountFlow(): Flow<`[`UpdateUnreadMessageCount`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateUnreadMessageCount.html)`>`

emits [UpdateUnreadMessageCount](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateUnreadMessageCount.html) if number of unread messages in a chat list has changed. This
update is sent only if the message database is used.

