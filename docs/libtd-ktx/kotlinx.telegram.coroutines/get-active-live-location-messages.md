---
title: getActiveLiveLocationMessages - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getActiveLiveLocationMessages](./get-active-live-location-messages.html)

# getActiveLiveLocationMessages

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getActiveLiveLocationMessages(): `[`Messages`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Messages.html)

Suspend function, which returns all active live locations that should be updated by the client.
The list is persistent across application restarts only if the message database is used.

**Return**
[Messages](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Messages.html) Contains a list of messages.

