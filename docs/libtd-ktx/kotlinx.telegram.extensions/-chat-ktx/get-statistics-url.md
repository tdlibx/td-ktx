---
title: ChatKtx.getStatisticsUrl - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [getStatisticsUrl](./get-statistics-url.html)

# getStatisticsUrl

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.getStatisticsUrl(parameters: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, isDark: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`HttpUrl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.HttpUrl.html)

Suspend function, which returns an HTTP URL with the chat statistics. Currently this method can
be used only for channels. Can be used only if SupergroupFullInfo.canViewStatistics == true.

### Parameters

`parameters` - Parameters from &amp;quot;tg://statsrefresh?params=******&quot; link.

`isDark` - Pass true if a URL with the dark theme must be returned.

**Return**
[TdApi.HttpUrl](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.HttpUrl.html) Contains an HTTP URL.

