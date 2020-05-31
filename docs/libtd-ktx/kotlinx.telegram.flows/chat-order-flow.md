---
title: chatOrderFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [chatOrderFlow](./chat-order-flow.html)

# chatOrderFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.chatOrderFlow(): Flow<`[`UpdateChatOrder`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateChatOrder.html)`>`

emits [UpdateChatOrder](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateChatOrder.html) if the order of the chat in the chat list has changed. Instead of this
update updateChatLastMessage, updateChatIsPinned, updateChatDraftMessage, or updateChatIsSponsored
might be sent.

