---
title: BasicGroupKtx - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [BasicGroupKtx](./index.html)

# BasicGroupKtx

`interface BasicGroupKtx : `[`BaseKtx`](../-base-ktx/index.html)

Interface for access [TdApi.BasicGroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html) extension functions. Can be used alongside with other
extension interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.html) instance field to access its
functionality

### Properties

| [api](api.html) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.html) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.html) |

### Functions

| [createChat](create-chat.html) | Suspend function, which returns an existing chat corresponding to a known basic group.`open suspend fun `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html)`.createChat(force: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html) |
| [get](get.html) | Suspend function, which returns information about a basic group by its identifier. This is an offline request if the current user is not a bot.`open suspend fun `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html)`.get(): `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html) |
| [getFullInfo](get-full-info.html) | Suspend function, which returns full information about a basic group by its identifier.`open suspend fun `[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html)`.getFullInfo(): `[`BasicGroupFullInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroupFullInfo.html) |

### Inheritors

| [TelegramKtx](../-telegram-ktx/index.html) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](./index.html)`, `[`CallKtx`](../-call-ktx/index.html)`, `[`ChatKtx`](../-chat-ktx/index.html)`, `[`FileKtx`](../-file-ktx/index.html)`, `[`MessageKtx`](../-message-ktx/index.html)`, `[`NotificationGroupKtx`](../-notification-group-ktx/index.html)`, `[`ProxyKtx`](../-proxy-ktx/index.html)`, `[`SecretChatKtx`](../-secret-chat-ktx/index.html)`, `[`SupergroupKtx`](../-supergroup-ktx/index.html)`, `[`UserKtx`](../-user-ktx/index.html)`, `[`CommonKtx`](../-common-ktx/index.html) |

