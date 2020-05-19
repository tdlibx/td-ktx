[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getBackgroundUrl](./get-background-url.md)

# getBackgroundUrl

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getBackgroundUrl(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, type: `[`BackgroundType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/BackgroundType.html)`?): `[`HttpUrl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html)

Suspend function, which constructs a persistent HTTP URL for a background.

### Parameters

`name` - Background name.

`type` - Background type.

**Return**
[HttpUrl](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/HttpUrl.html) Contains an HTTP URL.

