[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getMessageLinkInfo](./get-message-link-info.md)

# getMessageLinkInfo

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getMessageLinkInfo(url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`MessageLinkInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.MessageLinkInfo.html)

Suspend function, which returns information about a public or private message link.

### Parameters

`url` - The message link in the format &amp;quot;https://t.me/c/...&amp;quot;, or
&amp;quot;tg://privatepost?...&amp;quot;, or &amp;quot;https://t.me/username/...&amp;quot;, or
&amp;quot;tg://resolve?...&amp;quot;.

**Return**
[MessageLinkInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.MessageLinkInfo.html) Contains information about a link to a message in a chat.

