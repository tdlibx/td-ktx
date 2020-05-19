---
title: checkDatabaseEncryptionKey - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [checkDatabaseEncryptionKey](./check-database-encryption-key.html)

# checkDatabaseEncryptionKey

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.checkDatabaseEncryptionKey(encryptionKey: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which checks the database encryption key for correctness. Works only when the
current authorization state is authorizationStateWaitEncryptionKey.

### Parameters

`encryptionKey` - Encryption key to check or set up.