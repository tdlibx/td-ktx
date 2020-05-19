[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [createNewBasicGroupChat](./create-new-basic-group-chat.md)

# createNewBasicGroupChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.createNewBasicGroupChat(userIds: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`?, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)

Suspend function, which creates a new basic group and sends a corresponding
messageBasicGroupChatCreate. Returns the newly created chat.

### Parameters

`userIds` - Identifiers of users to be added to the basic group.

`title` - Title of the new basic group; 1-128 characters.

**Return**
[Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

