---
title: finishFileGeneration - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [finishFileGeneration](./finish-file-generation.html)

# finishFileGeneration

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.finishFileGeneration(generationId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, error: `[`Error`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Error.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which finishes the file generation.

### Parameters

`generationId` - The identifier of the generation process.

`error` - If set, means that file generation has failed and should be terminated.