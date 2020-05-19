[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [removeNotification](./remove-notification.md)

# removeNotification

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.removeNotification(notificationGroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, notificationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes an active notification from notification list. Needs to be called
only if the notification is removed by the current user.

### Parameters

`notificationGroupId` - Identifier of notification group to which the notification belongs.

`notificationId` - Identifier of removed notification.