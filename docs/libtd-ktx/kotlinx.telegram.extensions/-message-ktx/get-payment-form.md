---
title: MessageKtx.getPaymentForm - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [MessageKtx](index.html) / [getPaymentForm](./get-payment-form.html)

# getPaymentForm

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.getPaymentForm(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`PaymentForm`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PaymentForm.html)

Suspend function, which returns an invoice payment form. This method should be called when the
user presses inlineKeyboardButtonBuy.

### Parameters

`chatId` - Chat identifier of the Invoice message.

**Return**
[TdApi.PaymentForm](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PaymentForm.html) Contains information about an invoice payment form.

