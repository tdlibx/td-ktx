---
title: newPreCheckoutQueryFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [newPreCheckoutQueryFlow](./new-pre-checkout-query-flow.html)

# newPreCheckoutQueryFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.newPreCheckoutQueryFlow(): Flow<`[`UpdateNewPreCheckoutQuery`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateNewPreCheckoutQuery.html)`>`

emits [UpdateNewPreCheckoutQuery](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateNewPreCheckoutQuery.html) if a new incoming pre-checkout query; for bots only. Contains
full information about a checkout.

