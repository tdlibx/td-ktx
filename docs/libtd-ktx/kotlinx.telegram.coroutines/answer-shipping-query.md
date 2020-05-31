---
title: answerShippingQuery - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [answerShippingQuery](./answer-shipping-query.html)

# answerShippingQuery

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.answerShippingQuery(shippingQueryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, shippingOptions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`ShippingOption`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ShippingOption.html)`>?, errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets the result of a shipping query; for bots only.

### Parameters

`shippingQueryId` - Identifier of the shipping query.

`shippingOptions` - Available shipping options.

`errorMessage` - An error message, empty on success.