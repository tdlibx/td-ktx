---
title: recoverAuthenticationPassword - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [recoverAuthenticationPassword](./recover-authentication-password.html)

# recoverAuthenticationPassword

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.recoverAuthenticationPassword(recoveryCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which recovers the password with a password recovery code sent to an email
address that was previously set up. Works only when the current authorization state is
authorizationStateWaitPassword.

### Parameters

`recoveryCode` - Recovery code to check.