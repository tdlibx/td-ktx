---
title: sharePhoneNumber - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [sharePhoneNumber](./share-phone-number.html)

# sharePhoneNumber

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.sharePhoneNumber(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which shares the phone number of the current user with a mutual contact.
Supposed to be called when the user clicks on chatActionBarSharePhoneNumber.

### Parameters

`userId` - Identifier of the user with whom to share the phone number. The user must be a
mutual contact.