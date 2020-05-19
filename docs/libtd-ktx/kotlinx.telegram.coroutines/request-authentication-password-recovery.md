---
title: requestAuthenticationPasswordRecovery - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [requestAuthenticationPasswordRecovery](./request-authentication-password-recovery.html)

# requestAuthenticationPasswordRecovery

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.requestAuthenticationPasswordRecovery(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which requests to send a password recovery code to an email address that was
previously set up. Works only when the current authorization state is
authorizationStateWaitPassword.

