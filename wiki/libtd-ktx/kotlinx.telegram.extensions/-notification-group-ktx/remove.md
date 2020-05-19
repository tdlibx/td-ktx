[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [NotificationGroupKtx](index.md) / [remove](./remove.md)

# remove

`open suspend fun `[`NotificationGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/NotificationGroup.html)`.remove(maxNotificationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes a group of active notifications. Needs to be called only if the
notification group is removed by the current user.

### Parameters

`maxNotificationId` - The maximum identifier of removed notifications.