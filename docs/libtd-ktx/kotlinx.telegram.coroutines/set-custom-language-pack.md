---
title: setCustomLanguagePack - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setCustomLanguagePack](./set-custom-language-pack.html)

# setCustomLanguagePack

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setCustomLanguagePack(info: `[`LanguagePackInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LanguagePackInfo.html)`?, strings: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`LanguagePackString`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LanguagePackString.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds or changes a custom local language pack to the current localization
target.

### Parameters

`info` - Information about the language pack. Language pack ID must start with 'X', consist
only of English letters, digits and hyphens, and must not exceed 64 characters. Can be called before
authorization.

`strings` - Strings of the new language pack.