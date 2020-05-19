[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [createBasicGroupChat](./create-basic-group-chat.md)

# createBasicGroupChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.createBasicGroupChat(basicGroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, force: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)

Suspend function, which returns an existing chat corresponding to a known basic group.

### Parameters

`basicGroupId` - Basic group identifier.

`force` - If true, the chat will be created without network request. In this case all
information about the chat except its type, title and photo can be incorrect.

**Return**
[Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

