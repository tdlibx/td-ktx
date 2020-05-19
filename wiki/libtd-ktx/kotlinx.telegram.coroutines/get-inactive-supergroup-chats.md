[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getInactiveSupergroupChats](./get-inactive-supergroup-chats.md)

# getInactiveSupergroupChats

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getInactiveSupergroupChats(): `[`Chats`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html)

Suspend function, which returns a list of recently inactive supergroups and channels. Can be used
when user reaches limit on the number of joined supergroups and channels and receives
CHANNELSTOOMUCH error.

**Return**
[Chats](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html) Represents a list of chats.

