[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setFileGenerationProgress](./set-file-generation-progress.md)

# setFileGenerationProgress

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setFileGenerationProgress(generationId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, expectedSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, localPrefixSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs TDLib on a file generation progress.

### Parameters

`generationId` - The identifier of the generation process.

`expectedSize` - Expected size of the generated file, in bytes; 0 if unknown.

`localPrefixSize` - The number of bytes already generated.