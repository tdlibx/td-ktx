---
title: serviceNotificationFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [serviceNotificationFlow](./service-notification-flow.html)

# serviceNotificationFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.serviceNotificationFlow(): Flow<`[`UpdateServiceNotification`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateServiceNotification.html)`>`

emits [UpdateServiceNotification](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateServiceNotification.html) if service notification from the server. Upon receiving this
the client must show a popup with the content of the notification.

