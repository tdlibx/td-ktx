---
title: getRecoveryEmailAddress - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getRecoveryEmailAddress](./get-recovery-email-address.html)

# getRecoveryEmailAddress

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getRecoveryEmailAddress(password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`RecoveryEmailAddress`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.RecoveryEmailAddress.html)

Suspend function, which returns a 2-step verification recovery email address that was previously
set up. This method can be used to verify a password provided by the user.

### Parameters

`password` - The password for the current user.

**Return**
[RecoveryEmailAddress](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.RecoveryEmailAddress.html) Contains information about the current recovery email address.

