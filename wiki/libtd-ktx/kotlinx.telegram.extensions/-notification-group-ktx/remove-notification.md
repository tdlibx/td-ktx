[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [NotificationGroupKtx](index.md) / [removeNotification](./remove-notification.md)

# removeNotification

`open suspend fun `[`NotificationGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/NotificationGroup.html)`.removeNotification(notificationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes an active notification from notification list. Needs to be
called only if the notification is removed by the current user.

### Parameters

`notificationId` - Identifier of removed notification.