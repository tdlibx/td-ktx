[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setChatTitle](./set-chat-title.md)

# setChatTitle

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setChatTitle(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the chat title. Supported only for basic groups, supergroups and
channels. Requires canChangeInfo rights. The title will not be changed until the request to the
server has been completed.

### Parameters

`chatId` - Chat identifier.

`title` - New title of the chat; 1-128 characters.