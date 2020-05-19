[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setAutoDownloadSettings](./set-auto-download-settings.md)

# setAutoDownloadSettings

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setAutoDownloadSettings(settings: `[`AutoDownloadSettings`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/AutoDownloadSettings.html)`?, type: `[`NetworkType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/NetworkType.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sets auto-download settings.

### Parameters

`settings` - New user auto-download settings.

`type` - Type of the network for which the new settings are applied.