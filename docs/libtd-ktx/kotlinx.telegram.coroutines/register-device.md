---
title: registerDevice - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [registerDevice](./register-device.html)

# registerDevice

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.registerDevice(deviceToken: `[`DeviceToken`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/DeviceToken.html)`?, otherUserIds: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`?): `[`PushReceiverId`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PushReceiverId.html)

Suspend function, which registers the currently used device for receiving push notifications.
Returns a globally unique identifier of the push notification subscription.

### Parameters

`deviceToken` - Device token.

`otherUserIds` - List of user identifiers of other users currently using the client.

**Return**
[PushReceiverId](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/PushReceiverId.html) Contains a globally unique push receiver identifier, which can be used
to identify which account has received a push notification.

