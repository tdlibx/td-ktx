---
title: editCustomLanguagePackInfo - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [editCustomLanguagePackInfo](./edit-custom-language-pack-info.html)

# editCustomLanguagePackInfo

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.editCustomLanguagePackInfo(info: `[`LanguagePackInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LanguagePackInfo.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which edits information about a custom local language pack in the current
localization target. Can be called before authorization.

### Parameters

`info` - New information about the custom local language pack.