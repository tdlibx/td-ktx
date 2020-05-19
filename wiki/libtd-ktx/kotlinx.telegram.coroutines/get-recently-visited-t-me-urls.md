[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getRecentlyVisitedTMeUrls](./get-recently-visited-t-me-urls.md)

# getRecentlyVisitedTMeUrls

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getRecentlyVisitedTMeUrls(referrer: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`TMeUrls`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TMeUrls.html)

Suspend function, which returns t.me URLs recently visited by a newly registered user.

### Parameters

`referrer` - Google Play referrer to identify the user.

**Return**
[TMeUrls](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.TMeUrls.html) Contains a list of t.me URLs.

