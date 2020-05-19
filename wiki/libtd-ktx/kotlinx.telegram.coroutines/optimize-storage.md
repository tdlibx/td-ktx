[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [optimizeStorage](./optimize-storage.md)

# optimizeStorage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.optimizeStorage(size: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, ttl: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, count: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, immunityDelay: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, fileTypes: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`FileType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/FileType.html)`>?, chatIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?, excludeChatIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?, chatLimit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`StorageStatistics`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StorageStatistics.html)

Suspend function, which optimizes storage usage, i.e. deletes some files and returns new storage
usage statistics. Secret thumbnails can't be deleted.

### Parameters

`size` - Limit on the total size of files after deletion. Pass -1 to use the default limit.

`ttl` - Limit on the time that has passed since the last time a file was accessed (or creation
time for some filesystems). Pass -1 to use the default limit.

`count` - Limit on the total count of files after deletion. Pass -1 to use the default limit.

`immunityDelay` - The amount of time after the creation of a file during which it can't be
deleted, in seconds. Pass -1 to use the default value.

`fileTypes` - If not empty, only files with the given type(s) are considered. By default, all
types except thumbnails, profile photos, stickers and wallpapers are deleted.

`chatIds` - If not empty, only files from the given chats are considered. Use 0 as chat
identifier to delete files not belonging to any chat (e.g., profile photos).

`excludeChatIds` - If not empty, files from the given chats are excluded. Use 0 as chat
identifier to exclude all files not belonging to any chat (e.g., profile photos).

`chatLimit` - Same as in getStorageStatistics. Affects only returned statistics.

**Return**
[StorageStatistics](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StorageStatistics.html) Contains the exact storage usage statistics split by chats and file
type.

