[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [searchPublicChat](./search-public-chat.md)

# searchPublicChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.searchPublicChat(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)

Suspend function, which searches a public chat by its username. Currently only private chats,
supergroups and channels can be public. Returns the chat if found; otherwise an error is returned.

### Parameters

`username` - Username to be resolved.

**Return**
[Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

