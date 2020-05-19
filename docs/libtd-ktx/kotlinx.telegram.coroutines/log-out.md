---
title: logOut - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [logOut](./log-out.html)

# logOut

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.logOut(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which closes the TDLib instance after a proper logout. Requires an available
network connection. All local data will be destroyed. After the logout completes,
updateAuthorizationState with authorizationStateClosed will be sent.

