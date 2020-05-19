[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getLocalizationTargetInfo](./get-localization-target-info.md)

# getLocalizationTargetInfo

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getLocalizationTargetInfo(onlyLocal: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`LocalizationTargetInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LocalizationTargetInfo.html)

Suspend function, which returns information about the current localization target. This is an
offline request if onlyLocal is true. Can be called before authorization.

### Parameters

`onlyLocal` - If true, returns only locally available information without sending network
requests.

**Return**
[LocalizationTargetInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.LocalizationTargetInfo.html) Contains information about the current localization target.
