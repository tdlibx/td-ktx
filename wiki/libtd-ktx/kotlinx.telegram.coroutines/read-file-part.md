[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [readFilePart](./read-file-part.md)

# readFilePart

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.readFilePart(fileId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`FilePart`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/FilePart.html)

Suspend function, which reads a part of a file from the TDLib file cache and returns read bytes.
This method is intended to be used only if the client has no direct access to TDLib's file system,
because it is usually slower than a direct read from the file.

### Parameters

`fileId` - Identifier of the file. The file must be located in the TDLib file cache.

`offset` - The offset from which to read the file.

`count` - Number of bytes to read. An error will be returned if there are not enough bytes
available in the file from the specified position. Pass 0 to read all available data from the
specified position.

**Return**
[FilePart](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/FilePart.html) Contains a part of a file.

