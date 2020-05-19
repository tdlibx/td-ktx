[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [checkChangePhoneNumberCode](./check-change-phone-number-code.md)

# checkChangePhoneNumberCode

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.checkChangePhoneNumberCode(code: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which checks the authentication code sent to confirm a new phone number of the
user.

### Parameters

`code` - Verification code received by SMS, phone call or flash call.