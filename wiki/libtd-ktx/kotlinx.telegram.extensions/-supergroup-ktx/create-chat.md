[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [SupergroupKtx](index.md) / [createChat](./create-chat.md)

# createChat

`open suspend fun `[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Supergroup.html)`.createChat(force: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)

Suspend function, which returns an existing chat corresponding to a known supergroup or
channel.

### Parameters

`force` - If true, the chat will be created without network request. In this case all
information about the chat except its type, title and photo can be incorrect.

**Return**
[TdApi.Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

