---
title: writeGeneratedFilePart - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [writeGeneratedFilePart](./write-generated-file-part.html)

# writeGeneratedFilePart

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.writeGeneratedFilePart(generationId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, data: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which writes a part of a generated file. This method is intended to be used
only if the client has no direct access to TDLib's file system, because it is usually slower than a
direct write to the destination file.

### Parameters

`generationId` - The identifier of the generation process.

`offset` - The offset from which to write the data to the file.

`data` - The data to write.