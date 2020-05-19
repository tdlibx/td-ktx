---
title: getRecentlyVisitedTMeUrls - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getRecentlyVisitedTMeUrls](./get-recently-visited-t-me-urls.html)

# getRecentlyVisitedTMeUrls

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getRecentlyVisitedTMeUrls(referrer: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`TMeUrls`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TMeUrls.html)

Suspend function, which returns t.me URLs recently visited by a newly registered user.

### Parameters

`referrer` - Google Play referrer to identify the user.

**Return**
[TMeUrls](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/TMeUrls.html) Contains a list of t.me URLs.

