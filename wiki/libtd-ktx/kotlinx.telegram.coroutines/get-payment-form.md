[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getPaymentForm](./get-payment-form.md)

# getPaymentForm

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getPaymentForm(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`PaymentForm`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentForm.html)

Suspend function, which returns an invoice payment form. This method should be called when the
user presses inlineKeyboardButtonBuy.

### Parameters

`chatId` - Chat identifier of the Invoice message.

`messageId` - Message identifier.

**Return**
[PaymentForm](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentForm.html) Contains information about an invoice payment form.

