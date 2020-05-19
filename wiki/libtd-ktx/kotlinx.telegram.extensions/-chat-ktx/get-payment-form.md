[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [getPaymentForm](./get-payment-form.md)

# getPaymentForm

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.getPaymentForm(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`PaymentForm`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PaymentForm.html)

Suspend function, which returns an invoice payment form. This method should be called when the
user presses inlineKeyboardButtonBuy.

### Parameters

`messageId` - Message identifier.

**Return**
[TdApi.PaymentForm](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PaymentForm.html) Contains information about an invoice payment form.

