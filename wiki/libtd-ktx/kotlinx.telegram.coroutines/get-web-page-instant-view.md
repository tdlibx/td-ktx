[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getWebPageInstantView](./get-web-page-instant-view.md)

# getWebPageInstantView

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getWebPageInstantView(url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, forceFull: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`WebPageInstantView`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/WebPageInstantView.html)

Suspend function, which returns an instant view version of a web page if available. Returns a 404
error if the web page has no instant view page.

### Parameters

`url` - The web page URL.

`forceFull` - If true, the full instant view for the web page will be returned.

**Return**
[WebPageInstantView](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/WebPageInstantView.html) Describes an instant view page for a web page.

