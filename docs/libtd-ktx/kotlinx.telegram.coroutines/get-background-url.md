---
title: getBackgroundUrl - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getBackgroundUrl](./get-background-url.html)

# getBackgroundUrl

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getBackgroundUrl(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, type: `[`BackgroundType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BackgroundType.html)`?): `[`HttpUrl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.HttpUrl.html)

Suspend function, which constructs a persistent HTTP URL for a background.

### Parameters

`name` - Background name.

`type` - Background type.

**Return**
[HttpUrl](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.HttpUrl.html) Contains an HTTP URL.

