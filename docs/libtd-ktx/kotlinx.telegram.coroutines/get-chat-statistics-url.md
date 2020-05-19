---
title: getChatStatisticsUrl - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getChatStatisticsUrl](./get-chat-statistics-url.html)

# getChatStatisticsUrl

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getChatStatisticsUrl(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, parameters: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, isDark: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`HttpUrl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html)

Suspend function, which returns an HTTP URL with the chat statistics. Currently this method can
be used only for channels. Can be used only if SupergroupFullInfo.canViewStatistics == true.

### Parameters

`chatId` - Chat identifier.

`parameters` - Parameters from &amp;quot;tg://statsrefresh?params=******&quot; link.

`isDark` - Pass true if a URL with the dark theme must be returned.

**Return**
[HttpUrl](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html) Contains an HTTP URL.

