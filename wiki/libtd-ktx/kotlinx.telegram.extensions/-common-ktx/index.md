[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [CommonKtx](./index.md)

# CommonKtx

`interface CommonKtx : `[`BaseKtx`](../-base-ktx/index.md)

Interface for access common

### Properties

| [api](api.md) | Instance of the [TelegramFlow](../../kotlinx.telegram.core/-telegram-flow/index.md) connecting extensions to the Telegram Client`abstract val api: `[`TelegramFlow`](../../kotlinx.telegram.core/-telegram-flow/index.md) |

### Functions

| [delete](delete.md) | Suspend function, which deletes a profile photo. If something changes, updateUser will be sent.`open suspend fun `[`ProfilePhoto`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ProfilePhoto.html)`.delete(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [get](get.md) | Suspend function, which returns information about a file by its remote ID; this is an offline request. Can be used to register a URL as a file for further uploading, or sending as a message. Even the request succeeds, the file can be used only if it is still accessible to the user. For example, if the file is from a message, then the message must be not deleted and accessible to the user. If the file database is disabled, then the corresponding object with the file must be preloaded by the client.`open suspend fun `[`RemoteFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.RemoteFile.html)`.get(fileType: `[`FileType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.FileType.html)`?): `[`File`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.File.html) |
| [remove](remove.md) | Suspend function, which removes background from the list of installed backgrounds.`open suspend fun `[`Background`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Background.html)`.remove(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Suspend function, which removes an active notification from notification list. Needs to be called only if the notification is removed by the current user.`open suspend fun `[`Notification`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Notification.html)`.remove(notificationGroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [sendPaymentForm](send-payment-form.md) | Suspend function, which sends a filled-out payment form to the bot for final verification.`open suspend fun `[`ShippingOption`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ShippingOption.html)`.sendPaymentForm(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, orderInfoId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, credentials: `[`InputCredentials`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputCredentials.html)`?): `[`PaymentResult`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PaymentResult.html) |
| [setSupergroup](set-supergroup.md) | Suspend function, which changes the sticker set of a supergroup; requires canChangeInfo rights.`open suspend fun `[`StickerSet`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.StickerSet.html)`.setSupergroup(supergroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [terminate](terminate.md) | Suspend function, which terminates a session of the current user.`open suspend fun `[`Session`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Session.html)`.terminate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [TelegramKtx](../-telegram-ktx/index.md) | Interface for access all Telegram objects extension functions. Contains 182 extensions`interface TelegramKtx : `[`BasicGroupKtx`](../-basic-group-ktx/index.md)`, `[`CallKtx`](../-call-ktx/index.md)`, `[`ChatKtx`](../-chat-ktx/index.md)`, `[`FileKtx`](../-file-ktx/index.md)`, `[`MessageKtx`](../-message-ktx/index.md)`, `[`NotificationGroupKtx`](../-notification-group-ktx/index.md)`, `[`ProxyKtx`](../-proxy-ktx/index.md)`, `[`SecretChatKtx`](../-secret-chat-ktx/index.md)`, `[`SupergroupKtx`](../-supergroup-ktx/index.md)`, `[`UserKtx`](../-user-ktx/index.md)`, `[`CommonKtx`](./index.md) |

