[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getSuitableDiscussionChats](./get-suitable-discussion-chats.md)

# getSuitableDiscussionChats

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getSuitableDiscussionChats(): `[`Chats`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html)

Suspend function, which returns a list of basic group and supergroup chats, which can be used as
a discussion group for a channel. Basic group chats need to be first upgraded to supergroups before
they can be set as a discussion group.

**Return**
[Chats](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chats.html) Represents a list of chats.

