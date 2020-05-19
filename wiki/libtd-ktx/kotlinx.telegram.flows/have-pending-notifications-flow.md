[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [havePendingNotificationsFlow](./have-pending-notifications-flow.md)

# havePendingNotificationsFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.havePendingNotificationsFlow(): Flow<`[`UpdateHavePendingNotifications`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateHavePendingNotifications.html)`>`

emits [UpdateHavePendingNotifications](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateHavePendingNotifications.html) if describes whether there are some pending notification
updates. Can be used to prevent application from killing, while there are some pending
notifications.

