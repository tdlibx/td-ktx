[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getWebPagePreview](./get-web-page-preview.md)

# getWebPagePreview

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getWebPagePreview(text: `[`FormattedText`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/FormattedText.html)`?): `[`WebPage`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/WebPage.html)

Suspend function, which returns a web page preview by the text of the message. Do not call this
function too often. Returns a 404 error if the web page has no preview.

### Parameters

`text` - Message text with formatting.

**Return**
[WebPage](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/WebPage.html) Describes a web page preview.

