[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getAccountTtl](./get-account-ttl.md)

# getAccountTtl

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getAccountTtl(): `[`AccountTtl`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AccountTtl.html)

Suspend function, which returns the period of inactivity after which the account of the current
user will automatically be deleted.

**Return**
[AccountTtl](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.AccountTtl.html) Contains information about the period of inactivity after which the current
user's account will automatically be deleted.

