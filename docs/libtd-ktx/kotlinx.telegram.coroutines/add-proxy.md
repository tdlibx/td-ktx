---
title: addProxy - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [addProxy](./add-proxy.html)

# addProxy

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.addProxy(server: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, enable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, type: `[`ProxyType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ProxyType.html)`?): `[`Proxy`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Proxy.html)

Suspend function, which adds a proxy server for network requests. Can be called before
authorization.

### Parameters

`server` - Proxy server IP address.

`port` - Proxy server port.

`enable` - True, if the proxy should be enabled.

`type` - Proxy type.

**Return**
[Proxy](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Proxy.html) Contains information about a proxy server.

