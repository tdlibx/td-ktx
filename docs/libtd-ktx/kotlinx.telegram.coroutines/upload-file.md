---
title: uploadFile - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [uploadFile](./upload-file.html)

# uploadFile

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.uploadFile(file: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputFile.html)`?, fileType: `[`FileType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/FileType.html)`?, priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/File.html)

Suspend function, which asynchronously uploads a file to the cloud without sending it in a
message. updateFile will be used to notify about upload progress and successful completion of the
upload. The file will not have a persistent remote identifier until it will be sent in a message.

### Parameters

`file` - File to upload.

`fileType` - File type.

`priority` - Priority of the upload (1-32). The higher the priority, the earlier the file will
be uploaded. If the priorities of two files are equal, then the first one for which uploadFile was
called will be uploaded first.

**Return**
[File](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/File.html) Represents a file.

