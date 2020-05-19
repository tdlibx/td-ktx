---
title: setBotUpdatesStatus - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setBotUpdatesStatus](./set-bot-updates-status.html)

# setBotUpdatesStatus

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setBotUpdatesStatus(pendingUpdateCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs the server about the number of pending bot updates if they
haven't been processed for a long time; for bots only.

### Parameters

`pendingUpdateCount` - The number of pending updates.

`errorMessage` - The last error message.