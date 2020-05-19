---
title: destroy - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [destroy](./destroy.html)

# destroy

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.destroy(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which closes the TDLib instance, destroying all local data without a proper
logout. The current user session will remain in the list of all active sessions. All local data will
be destroyed. After the destruction completes updateAuthorizationState with authorizationStateClosed
will be sent.

