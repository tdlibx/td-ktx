---
title: checkAuthenticationCode - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [checkAuthenticationCode](./check-authentication-code.html)

# checkAuthenticationCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.checkAuthenticationCode(code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which checks the authentication code. Works only when the current authorization
state is authorizationStateWaitCode.

### Parameters

`code` - The verification code received via SMS, Telegram message, phone call, or flash call.