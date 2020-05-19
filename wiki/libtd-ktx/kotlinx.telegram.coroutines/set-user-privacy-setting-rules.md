[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setUserPrivacySettingRules](./set-user-privacy-setting-rules.md)

# setUserPrivacySettingRules

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setUserPrivacySettingRules(setting: `[`UserPrivacySetting`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserPrivacySetting.html)`?, rules: `[`UserPrivacySettingRules`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserPrivacySettingRules.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes user privacy settings.

### Parameters

`setting` - The privacy setting.

`rules` - The new privacy rules.