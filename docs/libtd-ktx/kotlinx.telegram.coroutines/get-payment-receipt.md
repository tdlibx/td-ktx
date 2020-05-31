---
title: getPaymentReceipt - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getPaymentReceipt](./get-payment-receipt.html)

# getPaymentReceipt

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getPaymentReceipt(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`PaymentReceipt`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentReceipt.html)

Suspend function, which returns information about a successful payment.

### Parameters

`chatId` - Chat identifier of the PaymentSuccessful message.

`messageId` - Message identifier.

**Return**
[PaymentReceipt](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentReceipt.html) Contains information about a successful payment.

