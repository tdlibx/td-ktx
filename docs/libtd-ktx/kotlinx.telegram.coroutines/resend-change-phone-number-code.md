---
title: resendChangePhoneNumberCode - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [resendChangePhoneNumberCode](./resend-change-phone-number-code.html)

# resendChangePhoneNumberCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.resendChangePhoneNumberCode(): `[`AuthenticationCodeInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/AuthenticationCodeInfo.html)

Suspend function, which re-sends the authentication code sent to confirm a new phone number for
the user. Works only if the previously received authenticationCodeInfo nextCodeType was not null.

**Return**
[AuthenticationCodeInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/AuthenticationCodeInfo.html) Information about the authentication code that was sent.

