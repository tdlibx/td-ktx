---
title: MessageKtx.openContent - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [MessageKtx](index.html) / [openContent](./open-content.html)

# openContent

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.openContent(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs TDLib that the message content has been opened (e.g., the user
has opened a photo, video, document, location or venue, or has listened to an audio file or voice
note message). An updateMessageContentOpened update will be generated if something has changed.

### Parameters

`chatId` - Chat identifier of the message.