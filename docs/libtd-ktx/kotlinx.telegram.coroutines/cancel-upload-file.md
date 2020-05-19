---
title: cancelUploadFile - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [cancelUploadFile](./cancel-upload-file.html)

# cancelUploadFile

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.cancelUploadFile(fileId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which stops the uploading of a file. Supported only for files uploaded by using
uploadFile. For other files the behavior is undefined.

### Parameters

`fileId` - Identifier of the file to stop uploading.