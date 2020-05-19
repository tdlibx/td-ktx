---
title: setChatDiscussionGroup - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [setChatDiscussionGroup](./set-chat-discussion-group.html)

# setChatDiscussionGroup

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.setChatDiscussionGroup(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, discussionChatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the discussion group of a channel chat; requires canChangeInfo
rights in the channel if it is specified.

### Parameters

`chatId` - Identifier of the channel chat. Pass 0 to remove a link from the supergroup passed
in the second argument to a linked channel chat (requires canPinMessages rights in the supergroup).

`discussionChatId` - Identifier of a new channel's discussion group. Use 0 to remove the
discussion group. Use the method getSuitableDiscussionChats to find all suitable groups. Basic group
chats needs to be first upgraded to supergroup chats. If new chat members don't have access to old
messages in the supergroup, then toggleSupergroupIsAllHistoryAvailable needs to be used first to
change that.