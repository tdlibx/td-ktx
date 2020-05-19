[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [chatOnlineMemberCountFlow](./chat-online-member-count-flow.md)

# chatOnlineMemberCountFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.chatOnlineMemberCountFlow(): Flow<`[`UpdateChatOnlineMemberCount`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatOnlineMemberCount.html)`>`

emits [UpdateChatOnlineMemberCount](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatOnlineMemberCount.html) if the number of online group members has changed. This
update with non-zero count is sent only for currently opened chats. There is no guarantee that it
will be sent just after the count has changed.

