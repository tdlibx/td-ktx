---
title: MessageKtx.getPaymentReceipt - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [MessageKtx](index.html) / [getPaymentReceipt](./get-payment-receipt.html)

# getPaymentReceipt

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.getPaymentReceipt(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`PaymentReceipt`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PaymentReceipt.html)

Suspend function, which returns information about a successful payment.

### Parameters

`chatId` - Chat identifier of the PaymentSuccessful message.

**Return**
[TdApi.PaymentReceipt](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PaymentReceipt.html) Contains information about a successful payment.

