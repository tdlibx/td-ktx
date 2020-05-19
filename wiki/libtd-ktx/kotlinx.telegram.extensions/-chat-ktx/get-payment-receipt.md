[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [getPaymentReceipt](./get-payment-receipt.md)

# getPaymentReceipt

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.getPaymentReceipt(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`PaymentReceipt`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentReceipt.html)

Suspend function, which returns information about a successful payment.

### Parameters

`messageId` - Message identifier.

**Return**
[TdApi.PaymentReceipt](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentReceipt.html) Contains information about a successful payment.

