---
title: ChatKtx.getMapThumbnailFile - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [getMapThumbnailFile](./get-map-thumbnail-file.html)

# getMapThumbnailFile

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.getMapThumbnailFile(location: `[`Location`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Location.html)`?, zoom: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, width: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, height: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, scale: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/File.html)

Suspend function, which returns information about a file with a map thumbnail in PNG format.
Only map thumbnail files with size less than 1MB can be downloaded.

### Parameters

`location` - Location of the map center.

`zoom` - Map zoom level; 13-20.

`width` - Map width in pixels before applying scale; 16-1024.

`height` - Map height in pixels before applying scale; 16-1024.

`scale` - Map scale; 1-3.

**Return**
[TdApi.File](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/File.html) Represents a file.

