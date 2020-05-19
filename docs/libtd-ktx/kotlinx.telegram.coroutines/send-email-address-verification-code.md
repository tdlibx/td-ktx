---
title: sendEmailAddressVerificationCode - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [sendEmailAddressVerificationCode](./send-email-address-verification-code.html)

# sendEmailAddressVerificationCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.sendEmailAddressVerificationCode(emailAddress: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`EmailAddressAuthenticationCodeInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/EmailAddressAuthenticationCodeInfo.html)

Suspend function, which sends a code to verify an email address to be added to a user's Telegram
Passport.

### Parameters

`emailAddress` - Email address.

**Return**
[EmailAddressAuthenticationCodeInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/EmailAddressAuthenticationCodeInfo.html) Information about the email address authentication
code that was sent.

