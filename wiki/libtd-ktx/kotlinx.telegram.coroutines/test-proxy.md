[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [testProxy](./test-proxy.md)

# testProxy

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.testProxy(server: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, port: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, type: `[`ProxyType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ProxyType.html)`?, dcId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, timeout: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sends a simple network request to the Telegram servers via proxy; for
testing only. Can be called before authorization.

### Parameters

`server` - Proxy server IP address.

`port` - Proxy server port.

`type` - Proxy type.

`dcId` - Identifier of a datacenter, with which to test connection.

`timeout` - The maximum overall timeout for the request.