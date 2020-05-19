[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [checkChatUsername](./check-chat-username.md)

# checkChatUsername

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.checkChatUsername(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`CheckChatUsernameResult`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CheckChatUsernameResult.html)

Suspend function, which checks whether a username can be set for a chat.

### Parameters

`chatId` - Chat identifier; should be identifier of a supergroup chat, or a channel chat, or a
private chat with self, or zero if chat is being created.

`username` - Username to be checked.

**Return**
[CheckChatUsernameResult](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CheckChatUsernameResult.html) This class is an abstract base class.

