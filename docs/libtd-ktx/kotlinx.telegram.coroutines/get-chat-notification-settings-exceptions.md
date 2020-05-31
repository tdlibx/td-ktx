---
title: getChatNotificationSettingsExceptions - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getChatNotificationSettingsExceptions](./get-chat-notification-settings-exceptions.html)

# getChatNotificationSettingsExceptions

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getChatNotificationSettingsExceptions(scope: `[`NotificationSettingsScope`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.NotificationSettingsScope.html)`?, compareSound: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Chats`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html)

Suspend function, which returns list of chats with non-default notification settings.

### Parameters

`scope` - If specified, only chats from the specified scope will be returned.

`compareSound` - If true, also chats with non-default sound will be returned.

**Return**
[Chats](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html) Represents a list of chats.

