---
title: ChatKtx.toggleIsPinned - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [toggleIsPinned](./toggle-is-pinned.html)

# toggleIsPinned

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.toggleIsPinned(isPinned: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the pinned state of a chat. You can pin up to
GetOption(&amp;quot;pinned_chat_count_max&amp;quot;)/GetOption(&amp;quot;pinned_archived_chat_count_max&amp;quot;)
non-secret chats and the same number of secret chats in the main/archive chat list.

### Parameters

`isPinned` - New value of isPinned.