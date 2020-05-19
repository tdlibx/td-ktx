---
title: checkAuthenticationPassword - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [checkAuthenticationPassword](./check-authentication-password.html)

# checkAuthenticationPassword

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.checkAuthenticationPassword(password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which checks the authentication password for correctness. Works only when the
current authorization state is authorizationStateWaitPassword.

### Parameters

`password` - The password to check.