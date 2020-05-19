---
title: checkRecoveryEmailAddressCode - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [checkRecoveryEmailAddressCode](./check-recovery-email-address-code.html)

# checkRecoveryEmailAddressCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.checkRecoveryEmailAddressCode(code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`PasswordState`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PasswordState.html)

Suspend function, which checks the 2-step verification recovery email address verification code.

### Parameters

`code` - Verification code.

**Return**
[PasswordState](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PasswordState.html) Represents the current state of 2-step verification.

