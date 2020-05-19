[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getStorageStatisticsFast](./get-storage-statistics-fast.md)

# getStorageStatisticsFast

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getStorageStatisticsFast(): `[`StorageStatisticsFast`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StorageStatisticsFast.html)

Suspend function, which quickly returns approximate storage usage statistics. Can be called
before authorization.

**Return**
[StorageStatisticsFast](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/StorageStatisticsFast.html) Contains approximate storage usage statistics, excluding files of
unknown file type.

