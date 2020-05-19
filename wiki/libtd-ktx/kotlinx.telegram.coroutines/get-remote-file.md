[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getRemoteFile](./get-remote-file.md)

# getRemoteFile

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getRemoteFile(remoteFileId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, fileType: `[`FileType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.FileType.html)`?): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)

Suspend function, which returns information about a file by its remote ID; this is an offline
request. Can be used to register a URL as a file for further uploading, or sending as a message.
Even the request succeeds, the file can be used only if it is still accessible to the user. For
example, if the file is from a message, then the message must be not deleted and accessible to the
user. If the file database is disabled, then the corresponding object with the file must be
preloaded by the client.

### Parameters

`remoteFileId` - Remote identifier of the file to get.

`fileType` - File type, if known.

**Return**
[File](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html) Represents a file.

