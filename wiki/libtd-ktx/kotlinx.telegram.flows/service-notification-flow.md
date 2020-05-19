[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [serviceNotificationFlow](./service-notification-flow.md)

# serviceNotificationFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.serviceNotificationFlow(): Flow<`[`UpdateServiceNotification`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateServiceNotification.html)`>`

emits [UpdateServiceNotification](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdateServiceNotification.html) if service notification from the server. Upon receiving this
the client must show a popup with the content of the notification.

