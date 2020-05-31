---
title: MessageKtx.deleteChatReplyMarkup - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [MessageKtx](index.html) / [deleteChatReplyMarkup](./delete-chat-reply-markup.html)

# deleteChatReplyMarkup

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)`.deleteChatReplyMarkup(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes the default reply markup from a chat. Must be called after a
one-time keyboard or a ForceReply reply markup has been used. UpdateChatReplyMarkup will be sent
if the reply markup will be changed.

### Parameters

`chatId` - Chat identifier.