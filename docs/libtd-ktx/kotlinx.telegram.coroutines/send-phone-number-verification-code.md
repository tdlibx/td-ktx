---
title: sendPhoneNumberVerificationCode - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [sendPhoneNumberVerificationCode](./send-phone-number-verification-code.html)

# sendPhoneNumberVerificationCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.sendPhoneNumberVerificationCode(phoneNumber: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, settings: `[`PhoneNumberAuthenticationSettings`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PhoneNumberAuthenticationSettings.html)`?): `[`AuthenticationCodeInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AuthenticationCodeInfo.html)

Suspend function, which sends a code to verify a phone number to be added to a user's Telegram
Passport.

### Parameters

`phoneNumber` - The phone number of the user, in international format.

`settings` - Settings for the authentication of the user's phone number.

**Return**
[AuthenticationCodeInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AuthenticationCodeInfo.html) Information about the authentication code that was sent.

