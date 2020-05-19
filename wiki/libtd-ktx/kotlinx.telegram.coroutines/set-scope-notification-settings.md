[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setScopeNotificationSettings](./set-scope-notification-settings.md)

# setScopeNotificationSettings

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setScopeNotificationSettings(scope: `[`NotificationSettingsScope`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.NotificationSettingsScope.html)`?, notificationSettings: `[`ScopeNotificationSettings`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ScopeNotificationSettings.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes notification settings for chats of a given type.

### Parameters

`scope` - Types of chats for which to change the notification settings.

`notificationSettings` - The new notification settings for the given scope.