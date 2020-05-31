---
title: SupergroupKtx - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [SupergroupKtx](./index.html)

# SupergroupKtx

`interface SupergroupKtx : `[`BaseKtx`](../-base-ktx/index.html)

Interface for access [TdApi.Supergroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html) extension functions. Can be used alongside with other
extension interfaces of the package. Must contain [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.html) instance field to access its
functionality

### Properties

| [api](api.html) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.html) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.html) |

### Functions

| [createChat](create-chat.html) | Suspend function, which returns an existing chat corresponding to a known supergroup or channel.`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.createChat(force: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html) |
| [delete](delete.html) | Suspend function, which deletes a supergroup or channel along with all messages in the corresponding chat. This will release the supergroup or channel username and remove all members; requires owner privileges in the supergroup or channel. Chats with more than 1000 members can't be deleted using this method.`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.delete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.html) | Suspend function, which returns information about a supergroup or a channel by its identifier. This is an offline request if the current user is not a bot.`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.get(): `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html) |
| [getFullInfo](get-full-info.html) | Suspend function, which returns full information about a supergroup or a channel by its identifier, cached for up to 1 minute.`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.getFullInfo(): `[`SupergroupFullInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SupergroupFullInfo.html) |
| [getMembers](get-members.html) | Suspend function, which returns information about members or banned users in a supergroup or channel. Can be used only if SupergroupFullInfo.canGetMembers == true; additionally, administrator privileges may be required for some filters.`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.getMembers(filter: `[`SupergroupMembersFilter`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.SupergroupMembersFilter.html)`?, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ChatMembers`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatMembers.html) |
| [reportSpam](report-spam.html) | Suspend function, which reports some messages from a user in a supergroup as spam; requires administrator rights in the supergroup.`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.reportSpam(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, messageIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setStickerSet](set-sticker-set.html) | Suspend function, which changes the sticker set of a supergroup; requires canChangeInfo rights.`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.setStickerSet(stickerSetId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setUsername](set-username.html) | Suspend function, which changes the username of a supergroup or channel, requires owner privileges in the supergroup or channel.`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.setUsername(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toggleIsAllHistoryAvailable](toggle-is-all-history-available.html) | Suspend function, which toggles whether the message history of a supergroup is available to new members; requires canChangeInfo rights.`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.toggleIsAllHistoryAvailable(isAllHistoryAvailable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toggleSignMessages](toggle-sign-messages.html) | Suspend function, which toggles sender signatures messages sent in a channel; requires canChangeInfo rights.`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`.toggleSignMessages(signMessages: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [TelegramKtx](../-telegram-ktx/index.html) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](../-basic-group-ktx/index.html)`, `[`CallKtx`](../-call-ktx/index.html)`, `[`ChatKtx`](../-chat-ktx/index.html)`, `[`FileKtx`](../-file-ktx/index.html)`, `[`MessageKtx`](../-message-ktx/index.html)`, `[`NotificationGroupKtx`](../-notification-group-ktx/index.html)`, `[`ProxyKtx`](../-proxy-ktx/index.html)`, `[`SecretChatKtx`](../-secret-chat-ktx/index.html)`, `[`SupergroupKtx`](./index.html)`, `[`UserKtx`](../-user-ktx/index.html)`, `[`CommonKtx`](../-common-ktx/index.html) |

