---
title: changePhoneNumber - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [changePhoneNumber](./change-phone-number.html)

# changePhoneNumber

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.changePhoneNumber(phoneNumber: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, settings: `[`PhoneNumberAuthenticationSettings`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PhoneNumberAuthenticationSettings.html)`?): `[`AuthenticationCodeInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AuthenticationCodeInfo.html)

Suspend function, which changes the phone number of the user and sends an authentication code to
the user's new phone number. On success, returns information about the sent code.

### Parameters

`phoneNumber` - The new phone number of the user in international format.

`settings` - Settings for the authentication of the user's phone number.

**Return**
[AuthenticationCodeInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AuthenticationCodeInfo.html) Information about the authentication code that was sent.

