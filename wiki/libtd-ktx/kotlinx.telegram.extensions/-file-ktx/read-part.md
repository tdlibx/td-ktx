[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [FileKtx](index.md) / [readPart](./read-part.md)

# readPart

`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.readPart(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`FilePart`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.FilePart.html)

Suspend function, which reads a part of a file from the TDLib file cache and returns read
bytes. This method is intended to be used only if the client has no direct access to TDLib's file
system, because it is usually slower than a direct read from the file.

### Parameters

`offset` - The offset from which to read the file.

`count` - Number of bytes to read. An error will be returned if there are not enough bytes
available in the file from the specified position. Pass 0 to read all available data from the
specified position.

**Return**
[TdApi.FilePart](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.FilePart.html) Contains a part of a file.

