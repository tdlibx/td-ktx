---
title: ChatKtx.openMessageContent - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [openMessageContent](./open-message-content.html)

# openMessageContent

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.openMessageContent(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs TDLib that the message content has been opened (e.g., the user
has opened a photo, video, document, location or venue, or has listened to an audio file or voice
note message). An updateMessageContentOpened update will be generated if something has changed.

### Parameters

`messageId` - Identifier of the message with the opened content.