---
title: sendChatSetTtlMessage - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [sendChatSetTtlMessage](./send-chat-set-ttl-message.html)

# sendChatSetTtlMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.sendChatSetTtlMessage(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, ttl: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which changes the current TTL setting (sets a new self-destruct timer) in a
secret chat and sends the corresponding message.

### Parameters

`chatId` - Chat identifier.

`ttl` - New TTL value, in seconds.

**Return**
[Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

