[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [removeNotificationGroup](./remove-notification-group.md)

# removeNotificationGroup

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.removeNotificationGroup(notificationGroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, maxNotificationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes a group of active notifications. Needs to be called only if the
notification group is removed by the current user.

### Parameters

`notificationGroupId` - Notification group identifier.

`maxNotificationId` - The maximum identifier of removed notifications.