---
title: checkChangePhoneNumberCode - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [checkChangePhoneNumberCode](./check-change-phone-number-code.html)

# checkChangePhoneNumberCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.checkChangePhoneNumberCode(code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which checks the authentication code sent to confirm a new phone number of the
user.

### Parameters

`code` - Verification code received by SMS, phone call or flash call.