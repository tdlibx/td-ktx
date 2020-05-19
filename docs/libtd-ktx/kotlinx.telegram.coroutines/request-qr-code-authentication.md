---
title: requestQrCodeAuthentication - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [requestQrCodeAuthentication](./request-qr-code-authentication.html)

# requestQrCodeAuthentication

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.requestQrCodeAuthentication(otherUserIds: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which requests QR code authentication by scanning a QR code on another logged
in device. Works only when the current authorization state is authorizationStateWaitPhoneNumber.

### Parameters

`otherUserIds` - List of user identifiers of other users currently using the client.