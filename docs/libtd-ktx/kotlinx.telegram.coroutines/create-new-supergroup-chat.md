---
title: createNewSupergroupChat - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [createNewSupergroupChat](./create-new-supergroup-chat.html)

# createNewSupergroupChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.createNewSupergroupChat(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, isChannel: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, location: `[`ChatLocation`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/ChatLocation.html)`?): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)

Suspend function, which creates a new supergroup or channel and sends a corresponding
messageSupergroupChatCreate. Returns the newly created chat.

### Parameters

`title` - Title of the new chat; 1-128 characters.

`isChannel` - True, if a channel chat should be created.

`description` - Chat description; 0-255 characters.

`location` - Chat location if a location-based supergroup is being created.

**Return**
[Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

