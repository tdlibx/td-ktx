---
title: NotificationGroupKtx.removeNotification - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [NotificationGroupKtx](index.html) / [removeNotification](./remove-notification.html)

# removeNotification

`open suspend fun `[`NotificationGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.NotificationGroup.html)`.removeNotification(notificationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes an active notification from notification list. Needs to be
called only if the notification is removed by the current user.

### Parameters

`notificationId` - Identifier of removed notification.