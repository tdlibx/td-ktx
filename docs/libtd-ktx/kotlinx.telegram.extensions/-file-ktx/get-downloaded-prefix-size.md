---
title: FileKtx.getDownloadedPrefixSize - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [FileKtx](index.html) / [getDownloadedPrefixSize](./get-downloaded-prefix-size.html)

# getDownloadedPrefixSize

`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/File.html)`.getDownloadedPrefixSize(offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Count`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Count.html)

Suspend function, which returns file downloaded prefix size from a given offset.

### Parameters

`offset` - Offset from which downloaded prefix size should be calculated.

**Return**
[TdApi.Count](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Count.html) Contains a counter.

