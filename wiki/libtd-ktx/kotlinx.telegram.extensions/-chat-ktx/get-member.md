[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [getMember](./get-member.md)

# getMember

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.getMember(userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ChatMember`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatMember.html)

Suspend function, which returns information about a single member of a chat.

### Parameters

`userId` - User identifier.

**Return**
[TdApi.ChatMember](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatMember.html) A user with information about joining/leaving a chat.

