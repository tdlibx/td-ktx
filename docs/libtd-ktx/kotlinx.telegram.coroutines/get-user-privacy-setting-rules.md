---
title: getUserPrivacySettingRules - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getUserPrivacySettingRules](./get-user-privacy-setting-rules.html)

# getUserPrivacySettingRules

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getUserPrivacySettingRules(setting: `[`UserPrivacySetting`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserPrivacySetting.html)`?): `[`UserPrivacySettingRules`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserPrivacySettingRules.html)

Suspend function, which returns the current privacy settings.

### Parameters

`setting` - The privacy setting.

**Return**
[UserPrivacySettingRules](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UserPrivacySettingRules.html) A list of privacy rules. Rules are matched in the specified
order. The first matched rule defines the privacy setting for a given user. If no rule matches, the
action is not allowed.

