---
title: resendAuthenticationCode - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [resendAuthenticationCode](./resend-authentication-code.html)

# resendAuthenticationCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.resendAuthenticationCode(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which re-sends an authentication code to the user. Works only when the current
authorization state is authorizationStateWaitCode and the nextCodeType of the result is not null.

