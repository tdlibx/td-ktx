---
title: setDatabaseEncryptionKey - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setDatabaseEncryptionKey](./set-database-encryption-key.html)

# setDatabaseEncryptionKey

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setDatabaseEncryptionKey(newEncryptionKey: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the database encryption key. Usually the encryption key is never
changed and is stored in some OS keychain.

### Parameters

`newEncryptionKey` - New encryption key.