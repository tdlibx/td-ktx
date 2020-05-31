---
title: ChatKtx.addLocalMessage - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [addLocalMessage](./add-local-message.html)

# addLocalMessage

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.addLocalMessage(senderUserId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, replyToMessageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, disableNotification: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, inputMessageContent: `[`InputMessageContent`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputMessageContent.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which adds a local message to a chat. The message is persistent across
application restarts only if the message database is used. Returns the added message.

### Parameters

`senderUserId` - Identifier of the user who will be shown as the sender of the message; may
be 0 for channel posts.

`replyToMessageId` - Identifier of the message to reply to or 0.

`disableNotification` - Pass true to disable notification for the message.

`inputMessageContent` - The content of the message to be added.

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

