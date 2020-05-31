---
title: ChatKtx.getPaymentForm - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [getPaymentForm](./get-payment-form.html)

# getPaymentForm

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.getPaymentForm(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`PaymentForm`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentForm.html)

Suspend function, which returns an invoice payment form. This method should be called when the
user presses inlineKeyboardButtonBuy.

### Parameters

`messageId` - Message identifier.

**Return**
[TdApi.PaymentForm](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentForm.html) Contains information about an invoice payment form.

