[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getCreatedPublicChats](./get-created-public-chats.md)

# getCreatedPublicChats

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getCreatedPublicChats(type: `[`PublicChatType`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.PublicChatType.html)`?): `[`Chats`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html)

Suspend function, which returns a list of public chats of the specified type, owned by the user.

### Parameters

`type` - Type of the public chats to return.

**Return**
[Chats](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html) Represents a list of chats.

