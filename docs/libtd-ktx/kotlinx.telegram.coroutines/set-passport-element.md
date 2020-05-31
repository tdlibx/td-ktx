---
title: setPassportElement - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setPassportElement](./set-passport-element.html)

# setPassportElement

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setPassportElement(element: `[`InputPassportElement`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputPassportElement.html)`?, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`PassportElement`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PassportElement.html)

Suspend function, which adds an element to the user's Telegram Passport. May return an error with
a message &amp;quot;PHONE_VERIFICATION_NEEDED&amp;quot; or &amp;quot;EMAIL_VERIFICATION_NEEDED&amp;quot; if the
chosen phone number or the chosen email address must be verified first.

### Parameters

`element` - Input Telegram Passport element.

`password` - Password of the current user.

**Return**
[PassportElement](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PassportElement.html) This class is an abstract base class.

