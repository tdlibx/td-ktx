[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [MessageKtx](index.md) / [getPaymentForm](./get-payment-form.md)

# getPaymentForm

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)`.getPaymentForm(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`PaymentForm`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentForm.html)

Suspend function, which returns an invoice payment form. This method should be called when the
user presses inlineKeyboardButtonBuy.

### Parameters

`chatId` - Chat identifier of the Invoice message.

**Return**
[TdApi.PaymentForm](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentForm.html) Contains information about an invoice payment form.

