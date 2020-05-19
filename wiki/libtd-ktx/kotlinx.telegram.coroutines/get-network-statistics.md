[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getNetworkStatistics](./get-network-statistics.md)

# getNetworkStatistics

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getNetworkStatistics(onlyCurrent: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`NetworkStatistics`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/NetworkStatistics.html)

Suspend function, which returns network data usage statistics. Can be called before
authorization.

### Parameters

`onlyCurrent` - If true, returns only data for the current library launch.

**Return**
[NetworkStatistics](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/NetworkStatistics.html) A full list of available network statistic entries.

