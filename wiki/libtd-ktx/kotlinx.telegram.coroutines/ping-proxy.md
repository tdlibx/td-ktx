[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [pingProxy](./ping-proxy.md)

# pingProxy

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.pingProxy(proxyId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Seconds`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Seconds.html)

Suspend function, which computes time needed to receive a response from a Telegram server through
a proxy. Can be called before authorization.

### Parameters

`proxyId` - Proxy identifier. Use 0 to ping a Telegram server without a proxy.

**Return**
[Seconds](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Seconds.html) Contains a value representing a number of seconds.

