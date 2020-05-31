---
title: searchHashtags - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [searchHashtags](./search-hashtags.html)

# searchHashtags

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.searchHashtags(prefix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Hashtags`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Hashtags.html)

Suspend function, which searches for recently used hashtags by their prefix.

### Parameters

`prefix` - Hashtag prefix to search for.

`limit` - The maximum number of hashtags to be returned.

**Return**
[Hashtags](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Hashtags.html) Contains a list of hashtags.

