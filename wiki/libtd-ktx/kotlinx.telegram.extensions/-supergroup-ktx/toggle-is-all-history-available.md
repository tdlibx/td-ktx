[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [SupergroupKtx](index.md) / [toggleIsAllHistoryAvailable](./toggle-is-all-history-available.md)

# toggleIsAllHistoryAvailable

`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.toggleIsAllHistoryAvailable(isAllHistoryAvailable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which toggles whether the message history of a supergroup is available to new
members; requires canChangeInfo rights.

### Parameters

`isAllHistoryAvailable` - The new value of isAllHistoryAvailable.