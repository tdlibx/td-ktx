---
title: enableProxy - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [enableProxy](./enable-proxy.html)

# enableProxy

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.enableProxy(proxyId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which enables a proxy. Only one proxy can be enabled at a time. Can be called
before authorization.

### Parameters

`proxyId` - Proxy identifier.