---
title: CommonKtx.remove - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [CommonKtx](index.html) / [remove](./remove.html)

# remove

`open suspend fun `[`Background`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Background.html)`.remove(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes background from the list of installed backgrounds.

`open suspend fun `[`Notification`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Notification.html)`.remove(notificationGroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which removes an active notification from notification list. Needs to be
called only if the notification is removed by the current user.

### Parameters

`notificationGroupId` - Identifier of notification group to which the notification belongs.