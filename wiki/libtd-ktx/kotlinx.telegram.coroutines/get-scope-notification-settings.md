[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getScopeNotificationSettings](./get-scope-notification-settings.md)

# getScopeNotificationSettings

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getScopeNotificationSettings(scope: `[`NotificationSettingsScope`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/NotificationSettingsScope.html)`?): `[`ScopeNotificationSettings`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ScopeNotificationSettings.html)

Suspend function, which returns the notification settings for chats of a given type.

### Parameters

`scope` - Types of chats for which to return the notification settings information.

**Return**
[ScopeNotificationSettings](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ScopeNotificationSettings.html) Contains information about notification settings for several
chats.

