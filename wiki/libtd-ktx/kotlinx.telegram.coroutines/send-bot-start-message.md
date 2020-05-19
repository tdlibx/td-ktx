[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [sendBotStartMessage](./send-bot-start-message.md)

# sendBotStartMessage

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.sendBotStartMessage(botUserId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, parameter: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which invites a bot to a chat (if it is not yet a member) and sends it the
/start command. Bots can't be invited to a private chat other than the chat with the bot. Bots can't
be invited to channels (although they can be added as admins) and secret chats. Returns the sent
message.

### Parameters

`botUserId` - Identifier of the bot.

`chatId` - Identifier of the target chat.

`parameter` - A hidden parameter sent to the bot for deep linking purposes
(https://core.telegram.org/bots#deep-linking).

**Return**
[Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

