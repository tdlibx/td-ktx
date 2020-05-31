---
title: checkChatInviteLink - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [checkChatInviteLink](./check-chat-invite-link.html)

# checkChatInviteLink

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.checkChatInviteLink(inviteLink: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`ChatInviteLinkInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatInviteLinkInfo.html)

Suspend function, which checks the validity of an invite link for a chat and returns information
about the corresponding chat.

### Parameters

`inviteLink` - Invite link to be checked; should begin with
&amp;quot;https://t.me/joinchat/&amp;quot;, &amp;quot;https://telegram.me/joinchat/&amp;quot;, or
&amp;quot;https://telegram.dog/joinchat/&amp;quot;.

**Return**
[ChatInviteLinkInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatInviteLinkInfo.html) Contains information about a chat invite link.

