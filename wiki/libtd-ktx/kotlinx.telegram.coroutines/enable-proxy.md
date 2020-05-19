[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [enableProxy](./enable-proxy.md)

# enableProxy

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.enableProxy(proxyId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which enables a proxy. Only one proxy can be enabled at a time. Can be called
before authorization.

### Parameters

`proxyId` - Proxy identifier.