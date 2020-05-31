---
title: ChatKtx.pinMessage - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [pinMessage](./pin-message.html)

# pinMessage

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.pinMessage(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, disableNotification: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which pins a message in a chat; requires canPinMessages rights.

### Parameters

`messageId` - Identifier of the new pinned message.

`disableNotification` - True, if there should be no notification about the pinned message.