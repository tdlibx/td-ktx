[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [newShippingQueryFlow](./new-shipping-query-flow.md)

# newShippingQueryFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.newShippingQueryFlow(): Flow<`[`UpdateNewShippingQuery`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateNewShippingQuery.html)`>`

emits [UpdateNewShippingQuery](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateNewShippingQuery.html) if a new incoming shipping query; for bots only. Only for invoices
with flexible price.

