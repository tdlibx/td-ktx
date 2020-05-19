---
title: sendPhoneNumberConfirmationCode - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [sendPhoneNumberConfirmationCode](./send-phone-number-confirmation-code.html)

# sendPhoneNumberConfirmationCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.sendPhoneNumberConfirmationCode(hash: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, phoneNumber: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, settings: `[`PhoneNumberAuthenticationSettings`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PhoneNumberAuthenticationSettings.html)`?): `[`AuthenticationCodeInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/AuthenticationCodeInfo.html)

Suspend function, which sends phone number confirmation code. Should be called when user presses
&amp;quot;https://t.me/confirmphone?phone=*******&amp;amp;hash=**********&quot; or&amp;quot;tg://confirmphone?phone=*******&amp;amp;hash=**********&quot; link.

### Parameters

`hash` - Value of the &amp;quot;hash&amp;quot; parameter from the link.

`phoneNumber` - Value of the &amp;quot;phone&amp;quot; parameter from the link.

`settings` - Settings for the authentication of the user's phone number.

**Return**
[AuthenticationCodeInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/AuthenticationCodeInfo.html) Information about the authentication code that was sent.

