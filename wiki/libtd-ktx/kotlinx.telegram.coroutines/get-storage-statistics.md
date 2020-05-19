[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getStorageStatistics](./get-storage-statistics.md)

# getStorageStatistics

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getStorageStatistics(chatLimit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`StorageStatistics`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StorageStatistics.html)

Suspend function, which returns storage usage statistics. Can be called before authorization.

### Parameters

`chatLimit` - The maximum number of chats with the largest storage usage for which separate
statistics should be returned. All other chats will be grouped in entries with chatId == 0. If the
chat info database is not used, the chatLimit is ignored and is always set to 0.

**Return**
[StorageStatistics](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StorageStatistics.html) Contains the exact storage usage statistics split by chats and file
type.

