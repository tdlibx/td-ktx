---
title: newShippingQueryFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [newShippingQueryFlow](./new-shipping-query-flow.html)

# newShippingQueryFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.newShippingQueryFlow(): Flow<`[`UpdateNewShippingQuery`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateNewShippingQuery.html)`>`

emits [UpdateNewShippingQuery](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateNewShippingQuery.html) if a new incoming shipping query; for bots only. Only for invoices
with flexible price.

