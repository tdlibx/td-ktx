[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [joinChatByInviteLink](./join-chat-by-invite-link.md)

# joinChatByInviteLink

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.joinChatByInviteLink(inviteLink: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)

Suspend function, which uses an invite link to add the current user to the chat if possible. The
new member will not be added until the chat state has been synchronized with the server.

### Parameters

`inviteLink` - Invite link to import; should begin with &amp;quot;https://t.me/joinchat/&amp;quot;,
&amp;quot;https://telegram.me/joinchat/&amp;quot;, or &amp;quot;https://telegram.dog/joinchat/&amp;quot;.

**Return**
[Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

