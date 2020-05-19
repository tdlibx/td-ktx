---
title: answerPreCheckoutQuery - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [answerPreCheckoutQuery](./answer-pre-checkout-query.html)

# answerPreCheckoutQuery

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.answerPreCheckoutQuery(preCheckoutQueryId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets the result of a pre-checkout query; for bots only.

### Parameters

`preCheckoutQueryId` - Identifier of the pre-checkout query.

`errorMessage` - An error message, empty on success.