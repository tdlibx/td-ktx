---
title: getLanguagePackStrings - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getLanguagePackStrings](./get-language-pack-strings.html)

# getLanguagePackStrings

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getLanguagePackStrings(languagePackId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, keys: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`LanguagePackStrings`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LanguagePackStrings.html)

Suspend function, which returns strings from a language pack in the current localization target
by their keys. Can be called before authorization.

### Parameters

`languagePackId` - Language pack identifier of the strings to be returned.

`keys` - Language pack keys of the strings to be returned; leave empty to request all
available strings.

**Return**
[LanguagePackStrings](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LanguagePackStrings.html) Contains a list of language pack strings.

