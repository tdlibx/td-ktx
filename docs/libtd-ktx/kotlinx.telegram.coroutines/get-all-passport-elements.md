---
title: getAllPassportElements - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getAllPassportElements](./get-all-passport-elements.html)

# getAllPassportElements

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getAllPassportElements(password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`PassportElements`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PassportElements.html)

Suspend function, which returns all available Telegram Passport elements.

### Parameters

`password` - Password of the current user.

**Return**
[PassportElements](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PassportElements.html) Contains information about saved Telegram Passport elements.

