[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [FileKtx](./index.md)

# FileKtx

`interface FileKtx : `[`BaseKtx`](../-base-ktx/index.md)

Interface for access [TdApi.File](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html) extension functions. Can be used alongside with other extension
interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) instance field to access its functionality

### Properties

| Name | Summary |
|---|---|
| [api](api.md) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.md) |

### Functions

| Name | Summary |
|---|---|
| [cancelDownload](cancel-download.md) | Suspend function, which stops the downloading of a file. If a file has already been downloaded, does nothing.`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.cancelDownload(onlyIfPending: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [cancelUpload](cancel-upload.md) | Suspend function, which stops the uploading of a file. Supported only for files uploaded by using uploadFile. For other files the behavior is undefined.`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.cancelUpload(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [delete](delete.md) | Suspend function, which deletes a file from the TDLib file cache.`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.delete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [download](download.md) | Suspend function, which downloads a file from the cloud. Download progress and completion of the download will be notified through updateFile updates.`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.download(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, synchronous: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html) |
| [get](get.md) | Suspend function, which returns information about a file; this is an offline request.`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.get(): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html) |
| [getAttachedStickerSets](get-attached-sticker-sets.md) | Suspend function, which returns a list of sticker sets attached to a file. Currently only photos and videos can have attached sticker sets.`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.getAttachedStickerSets(): `[`StickerSets`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.StickerSets.html) |
| [getDownloadedPrefixSize](get-downloaded-prefix-size.md) | Suspend function, which returns file downloaded prefix size from a given offset.`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.getDownloadedPrefixSize(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Count`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Count.html) |
| [readPart](read-part.md) | Suspend function, which reads a part of a file from the TDLib file cache and returns read bytes. This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct read from the file.`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.readPart(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`FilePart`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.FilePart.html) |

### Inheritors

| Name | Summary |
|---|---|
| [TelegramKtx](../-telegram-ktx/index.md) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](../-basic-group-ktx/index.md)`, `[`CallKtx`](../-call-ktx/index.md)`, `[`ChatKtx`](../-chat-ktx/index.md)`, `[`FileKtx`](./index.md)`, `[`MessageKtx`](../-message-ktx/index.md)`, `[`NotificationGroupKtx`](../-notification-group-ktx/index.md)`, `[`ProxyKtx`](../-proxy-ktx/index.md)`, `[`SecretChatKtx`](../-secret-chat-ktx/index.md)`, `[`SupergroupKtx`](../-supergroup-ktx/index.md)`, `[`UserKtx`](../-user-ktx/index.md)`, `[`CommonKtx`](../-common-ktx/index.md) |
