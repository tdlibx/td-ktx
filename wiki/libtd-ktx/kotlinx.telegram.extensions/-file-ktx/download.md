[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [FileKtx](index.md) / [download](./download.md)

# download

`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.download(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, synchronous: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)

Suspend function, which downloads a file from the cloud. Download progress and completion of
the download will be notified through updateFile updates.

### Parameters

`priority` - Priority of the download (1-32). The higher the priority, the earlier the file
will be downloaded. If the priorities of two files are equal, then the last one for which
downloadFile was called will be downloaded first.

`offset` - The starting position from which the file should be downloaded.

`limit` - Number of bytes which should be downloaded starting from the &amp;quot;offset&amp;quot;
position before the download will be automatically cancelled; use 0 to download without a limit.

`synchronous` - If false, this request returns file state just after the download has been
started. If true, this request returns file state only after the download has succeeded, has
failed, has been cancelled or a new downloadFile request with different offset/limit parameters
was sent.

**Return**
[TdApi.File](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html) Represents a file.

