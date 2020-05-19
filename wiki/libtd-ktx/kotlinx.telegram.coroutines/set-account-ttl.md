[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setAccountTtl](./set-account-ttl.md)

# setAccountTtl

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setAccountTtl(ttl: `[`AccountTtl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AccountTtl.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the period of inactivity after which the account of the current
user will automatically be deleted.

### Parameters

`ttl` - New account TTL.