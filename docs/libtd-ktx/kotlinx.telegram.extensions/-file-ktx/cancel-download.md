---
title: FileKtx.cancelDownload - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [FileKtx](index.html) / [cancelDownload](./cancel-download.html)

# cancelDownload

`open suspend fun `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html)`.cancelDownload(onlyIfPending: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which stops the downloading of a file. If a file has already been downloaded,
does nothing.

### Parameters

`onlyIfPending` - Pass true to stop downloading only if it hasn't been started, i.e. request
hasn't been sent to server.