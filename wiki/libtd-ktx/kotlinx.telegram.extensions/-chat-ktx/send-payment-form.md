[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [sendPaymentForm](./send-payment-form.md)

# sendPaymentForm

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.sendPaymentForm(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, orderInfoId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, shippingOptionId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, credentials: `[`InputCredentials`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputCredentials.html)`?): `[`PaymentResult`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PaymentResult.html)

Suspend function, which sends a filled-out payment form to the bot for final verification.

### Parameters

`messageId` - Message identifier.

`orderInfoId` - Identifier returned by ValidateOrderInfo, or an empty string.

`shippingOptionId` - Identifier of a chosen shipping option, if applicable.

`credentials` - The credentials chosen by user for payment.

**Return**
[TdApi.PaymentResult](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PaymentResult.html) Contains the result of a payment request.

