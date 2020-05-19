[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [checkCreatedPublicChatsLimit](./check-created-public-chats-limit.md)

# checkCreatedPublicChatsLimit

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.checkCreatedPublicChatsLimit(type: `[`PublicChatType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PublicChatType.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which checks whether the maximum number of owned public chats has been reached.
Returns corresponding error if the limit was reached.

### Parameters

`type` - Type of the public chats, for which to check the limit.