---
title: chatDefaultDisableNotificationFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [chatDefaultDisableNotificationFlow](./chat-default-disable-notification-flow.html)

# chatDefaultDisableNotificationFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.chatDefaultDisableNotificationFlow(): Flow<`[`UpdateChatDefaultDisableNotification`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatDefaultDisableNotification.html)`>`

emits [UpdateChatDefaultDisableNotification](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/UpdateChatDefaultDisableNotification.html) if the value of the default disableNotification
parameter, used when a message is sent to the chat, was changed.

