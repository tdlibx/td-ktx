---
title: getEmojiSuggestionsUrl - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getEmojiSuggestionsUrl](./get-emoji-suggestions-url.html)

# getEmojiSuggestionsUrl

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getEmojiSuggestionsUrl(languageCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`HttpUrl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html)

Suspend function, which returns an HTTP URL which can be used to automatically log in to the
translation platform and suggest new emoji replacements. The URL will be valid for 30 seconds after
generation.

### Parameters

`languageCode` - Language code for which the emoji replacements will be suggested.

**Return**
[HttpUrl](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html) Contains an HTTP URL.

