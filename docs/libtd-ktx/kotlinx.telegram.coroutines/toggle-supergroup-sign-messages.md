---
title: toggleSupergroupSignMessages - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [toggleSupergroupSignMessages](./toggle-supergroup-sign-messages.html)

# toggleSupergroupSignMessages

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.toggleSupergroupSignMessages(supergroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, signMessages: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which toggles sender signatures messages sent in a channel; requires
canChangeInfo rights.

### Parameters

`supergroupId` - Identifier of the channel.

`signMessages` - New value of signMessages.