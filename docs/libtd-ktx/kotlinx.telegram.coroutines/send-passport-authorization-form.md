---
title: sendPassportAuthorizationForm - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [sendPassportAuthorizationForm](./send-passport-authorization-form.html)

# sendPassportAuthorizationForm

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.sendPassportAuthorizationForm(autorizationFormId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, types: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`PassportElementType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PassportElementType.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sends a Telegram Passport authorization form, effectively sharing data
with the service. This method must be called after getPassportAuthorizationFormAvailableElements if
some previously available elements need to be used.

### Parameters

`autorizationFormId` - Authorization form identifier.

`types` - Types of Telegram Passport elements chosen by user to complete the authorization
form.