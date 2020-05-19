[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [setDiscussionGroup](./set-discussion-group.md)

# setDiscussionGroup

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.setDiscussionGroup(discussionChatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the discussion group of a channel chat; requires canChangeInfo
rights in the channel if it is specified.

### Parameters

`discussionChatId` - Identifier of a new channel's discussion group. Use 0 to remove the
discussion group. Use the method getSuitableDiscussionChats to find all suitable groups. Basic
group chats needs to be first upgraded to supergroup chats. If new chat members don't have access
to old messages in the supergroup, then toggleSupergroupIsAllHistoryAvailable needs to be used
first to change that.