[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [addNetworkStatistics](./add-network-statistics.md)

# addNetworkStatistics

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.addNetworkStatistics(entry: `[`NetworkStatisticsEntry`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.NetworkStatisticsEntry.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which adds the specified data to data usage statistics. Can be called before
authorization.

### Parameters

`entry` - The network statistics entry with the data to be added to statistics.