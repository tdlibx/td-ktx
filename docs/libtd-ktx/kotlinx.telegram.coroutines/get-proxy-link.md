---
title: getProxyLink - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getProxyLink](./get-proxy-link.html)

# getProxyLink

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getProxyLink(proxyId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Text`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Text.html)

Suspend function, which returns an HTTPS link, which can be used to add a proxy. Available only
for SOCKS5 and MTProto proxies. Can be called before authorization.

### Parameters

`proxyId` - Proxy identifier.

**Return**
[Text](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Text.html) Contains some text.

