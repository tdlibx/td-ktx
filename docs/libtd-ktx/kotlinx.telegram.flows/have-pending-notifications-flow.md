---
title: havePendingNotificationsFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [havePendingNotificationsFlow](./have-pending-notifications-flow.html)

# havePendingNotificationsFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.havePendingNotificationsFlow(): Flow<`[`UpdateHavePendingNotifications`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateHavePendingNotifications.html)`>`

emits [UpdateHavePendingNotifications](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateHavePendingNotifications.html) if describes whether there are some pending notification
updates. Can be used to prevent application from killing, while there are some pending
notifications.

