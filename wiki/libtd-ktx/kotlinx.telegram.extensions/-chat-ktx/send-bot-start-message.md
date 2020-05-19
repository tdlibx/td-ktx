[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [sendBotStartMessage](./send-bot-start-message.md)

# sendBotStartMessage

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Chat.html)`.sendBotStartMessage(botUserId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, parameter: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)

Suspend function, which invites a bot to a chat (if it is not yet a member) and sends it the
/start command. Bots can't be invited to a private chat other than the chat with the bot. Bots
can't be invited to channels (although they can be added as admins) and secret chats. Returns the
sent message.

### Parameters

`botUserId` - Identifier of the bot.

`parameter` - A hidden parameter sent to the bot for deep linking purposes
(https://core.telegram.org/bots#deep-linking).

**Return**
[TdApi.Message](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html) Describes a message.

