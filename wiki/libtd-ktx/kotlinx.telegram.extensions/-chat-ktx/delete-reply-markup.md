[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [deleteReplyMarkup](./delete-reply-markup.md)

# deleteReplyMarkup

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.deleteReplyMarkup(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes the default reply markup from a chat. Must be called after a
one-time keyboard or a ForceReply reply markup has been used. UpdateChatReplyMarkup will be sent
if the reply markup will be changed.

### Parameters

`messageId` - The message identifier of the used keyboard.