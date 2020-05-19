[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [viewMessages](./view-messages.md)

# viewMessages

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.viewMessages(messageIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?, forceRead: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which informs TDLib that messages are being viewed by the user. Many useful
activities depend on whether the messages are currently being viewed or not (e.g., marking
messages as read, incrementing a view counter, updating a view counter, removing deleted messages
in supergroups and channels).

### Parameters

`messageIds` - The identifiers of the messages being viewed.

`forceRead` - True, if messages in closed chats should be marked as read.