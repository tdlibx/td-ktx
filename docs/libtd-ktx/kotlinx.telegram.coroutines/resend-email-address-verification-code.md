---
title: resendEmailAddressVerificationCode - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [resendEmailAddressVerificationCode](./resend-email-address-verification-code.html)

# resendEmailAddressVerificationCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.resendEmailAddressVerificationCode(): `[`EmailAddressAuthenticationCodeInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/EmailAddressAuthenticationCodeInfo.html)

Suspend function, which re-sends the code to verify an email address to be added to a user's
Telegram Passport.

**Return**
[EmailAddressAuthenticationCodeInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/EmailAddressAuthenticationCodeInfo.html) Information about the email address authentication
code that was sent.

