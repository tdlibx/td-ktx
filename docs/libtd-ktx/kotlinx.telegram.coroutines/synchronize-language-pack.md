---
title: synchronizeLanguagePack - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [synchronizeLanguagePack](./synchronize-language-pack.html)

# synchronizeLanguagePack

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.synchronizeLanguagePack(languagePackId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which fetches the latest versions of all strings from a language pack in the
current localization target from the server. This method doesn't need to be called explicitly for
the current used/base language packs. Can be called before authorization.

### Parameters

`languagePackId` - Language pack identifier.