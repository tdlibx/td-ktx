---
title: getFile - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getFile](./get-file.html)

# getFile

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getFile(fileId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)

Suspend function, which returns information about a file; this is an offline request.

### Parameters

`fileId` - Identifier of the file to get.

**Return**
[File](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html) Represents a file.

