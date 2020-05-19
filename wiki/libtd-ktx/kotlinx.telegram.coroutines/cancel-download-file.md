[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [cancelDownloadFile](./cancel-download-file.md)

# cancelDownloadFile

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.cancelDownloadFile(fileId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, onlyIfPending: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which stops the downloading of a file. If a file has already been downloaded,
does nothing.

### Parameters

`fileId` - Identifier of a file to stop downloading.

`onlyIfPending` - Pass true to stop downloading only if it hasn't been started, i.e. request
hasn't been sent to server.