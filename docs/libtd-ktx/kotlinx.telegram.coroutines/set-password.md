---
title: setPassword - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setPassword](./set-password.html)

# setPassword

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setPassword(oldPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, newPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, newHint: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, setRecoveryEmailAddress: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, newRecoveryEmailAddress: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`PasswordState`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PasswordState.html)

Suspend function, which changes the password for the user. If a new recovery email address is
specified, then the change will not be applied until the new recovery email address is confirmed.

### Parameters

`oldPassword` - Previous password of the user.

`newPassword` - New password of the user; may be empty to remove the password.

`newHint` - New password hint; may be empty.

`setRecoveryEmailAddress` - Pass true if the recovery email address should be changed.

`newRecoveryEmailAddress` - New recovery email address; may be empty.

**Return**
[PasswordState](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PasswordState.html) Represents the current state of 2-step verification.

