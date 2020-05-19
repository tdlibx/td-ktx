---
title: UserKtx.setPassportElementErrors - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [UserKtx](index.html) / [setPassportElementErrors](./set-passport-element-errors.html)

# setPassportElementErrors

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html)`.setPassportElementErrors(errors: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`InputPassportElementError`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputPassportElementError.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs the user that some of the elements in their Telegram Passport
contain errors; for bots only. The user will not be able to resend the elements, until the errors
are fixed.

### Parameters

`errors` - The errors.