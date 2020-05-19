[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [sharePhoneNumber](./share-phone-number.md)

# sharePhoneNumber

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.sharePhoneNumber(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which shares the phone number of the current user with a mutual contact.
Supposed to be called when the user clicks on chatActionBarSharePhoneNumber.

### Parameters

`userId` - Identifier of the user with whom to share the phone number. The user must be a
mutual contact.