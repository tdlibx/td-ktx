---
title: reportSupergroupSpam - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [reportSupergroupSpam](./report-supergroup-spam.html)

# reportSupergroupSpam

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.reportSupergroupSpam(supergroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, messageIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which reports some messages from a user in a supergroup as spam; requires
administrator rights in the supergroup.

### Parameters

`supergroupId` - Supergroup identifier.

`userId` - User identifier.

`messageIds` - Identifiers of messages sent in the supergroup by the user. This list must be
non-empty.