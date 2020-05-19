---
title: sendPaymentForm - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [sendPaymentForm](./send-payment-form.html)

# sendPaymentForm

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.sendPaymentForm(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, orderInfoId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, shippingOptionId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, credentials: `[`InputCredentials`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputCredentials.html)`?): `[`PaymentResult`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PaymentResult.html)

Suspend function, which sends a filled-out payment form to the bot for final verification.

### Parameters

`chatId` - Chat identifier of the Invoice message.

`messageId` - Message identifier.

`orderInfoId` - Identifier returned by ValidateOrderInfo, or an empty string.

`shippingOptionId` - Identifier of a chosen shipping option, if applicable.

`credentials` - The credentials chosen by user for payment.

**Return**
[PaymentResult](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PaymentResult.html) Contains the result of a payment request.

