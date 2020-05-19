---
title: CommonKtx.get - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [CommonKtx](index.html) / [get](./get.html)

# get

`open suspend fun `[`RemoteFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/RemoteFile.html)`.get(fileType: `[`FileType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/FileType.html)`?): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/File.html)

Suspend function, which returns information about a file by its remote ID; this is an offline
request. Can be used to register a URL as a file for further uploading, or sending as a message.
Even the request succeeds, the file can be used only if it is still accessible to the user. For
example, if the file is from a message, then the message must be not deleted and accessible to the
user. If the file database is disabled, then the corresponding object with the file must be
preloaded by the client.

### Parameters

`fileType` - File type, if known.

**Return**
[TdApi.File](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/File.html) Represents a file.

