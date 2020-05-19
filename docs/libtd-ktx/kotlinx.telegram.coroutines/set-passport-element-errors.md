---
title: setPassportElementErrors - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setPassportElementErrors](./set-passport-element-errors.html)

# setPassportElementErrors

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setPassportElementErrors(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, errors: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`InputPassportElementError`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputPassportElementError.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs the user that some of the elements in their Telegram Passport
contain errors; for bots only. The user will not be able to resend the elements, until the errors
are fixed.

### Parameters

`userId` - User identifier.

`errors` - The errors.