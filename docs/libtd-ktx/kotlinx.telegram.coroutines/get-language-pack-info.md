---
title: getLanguagePackInfo - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getLanguagePackInfo](./get-language-pack-info.html)

# getLanguagePackInfo

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getLanguagePackInfo(languagePackId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`LanguagePackInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LanguagePackInfo.html)

Suspend function, which returns information about a language pack. Returned language pack
identifier may be different from a provided one. Can be called before authorization.

### Parameters

`languagePackId` - Language pack identifier.

**Return**
[LanguagePackInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LanguagePackInfo.html) Contains information about a language pack.

