---
title: setAuthenticationPhoneNumber - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setAuthenticationPhoneNumber](./set-authentication-phone-number.html)

# setAuthenticationPhoneNumber

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setAuthenticationPhoneNumber(phoneNumber: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, settings: `[`PhoneNumberAuthenticationSettings`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PhoneNumberAuthenticationSettings.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets the phone number of the user and sends an authentication code to the
user. Works only when the current authorization state is authorizationStateWaitPhoneNumber, or if
there is no pending authentication query and the current authorization state is
authorizationStateWaitCode, authorizationStateWaitRegistration, or authorizationStateWaitPassword.

### Parameters

`phoneNumber` - The phone number of the user, in international format.

`settings` - Settings for the authentication of the user's phone number.