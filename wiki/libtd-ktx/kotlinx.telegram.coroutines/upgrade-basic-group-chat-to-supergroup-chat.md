[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [upgradeBasicGroupChatToSupergroupChat](./upgrade-basic-group-chat-to-supergroup-chat.md)

# upgradeBasicGroupChatToSupergroupChat

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.upgradeBasicGroupChatToSupergroupChat(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)

Suspend function, which creates a new supergroup from an existing basic group and sends a
corresponding messageChatUpgradeTo and messageChatUpgradeFrom; requires creator privileges.
Deactivates the original basic group.

### Parameters

`chatId` - Identifier of the chat to upgrade.

**Return**
[Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

