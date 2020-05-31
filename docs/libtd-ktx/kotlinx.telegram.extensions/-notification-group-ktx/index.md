---
title: NotificationGroupKtx - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [NotificationGroupKtx](./index.html)

# NotificationGroupKtx

`interface NotificationGroupKtx : `[`BaseKtx`](../-base-ktx/index.html)

Interface for access [TdApi.NotificationGroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.NotificationGroup.html) extension functions. Can be used alongside with
other extension interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.html) instance field to access its
functionality

### Properties

| [api](api.html) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.html) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.html) |

### Functions

| [remove](remove.html) | Suspend function, which removes a group of active notifications. Needs to be called only if the notification group is removed by the current user.`open suspend fun `[`NotificationGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.NotificationGroup.html)`.remove(maxNotificationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeNotification](remove-notification.html) | Suspend function, which removes an active notification from notification list. Needs to be called only if the notification is removed by the current user.`open suspend fun `[`NotificationGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.NotificationGroup.html)`.removeNotification(notificationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [TelegramKtx](../-telegram-ktx/index.html) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](../-basic-group-ktx/index.html)`, `[`CallKtx`](../-call-ktx/index.html)`, `[`ChatKtx`](../-chat-ktx/index.html)`, `[`FileKtx`](../-file-ktx/index.html)`, `[`MessageKtx`](../-message-ktx/index.html)`, `[`NotificationGroupKtx`](./index.html)`, `[`ProxyKtx`](../-proxy-ktx/index.html)`, `[`SecretChatKtx`](../-secret-chat-ktx/index.html)`, `[`SupergroupKtx`](../-supergroup-ktx/index.html)`, `[`UserKtx`](../-user-ktx/index.html)`, `[`CommonKtx`](../-common-ktx/index.html) |

