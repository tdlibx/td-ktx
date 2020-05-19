[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [activeNotificationsFlow](./active-notifications-flow.md)

# activeNotificationsFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.activeNotificationsFlow(): Flow<`[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`NotificationGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.NotificationGroup.html)`>>`

emits groups [NotificationGroup[]] if contains active notifications that was shown on previous
application launches. This update is sent only if the message database is used. In that case it
comes once before any updateNotification and updateNotificationGroup update.

