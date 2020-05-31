---
title: getConnectedWebsites - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getConnectedWebsites](./get-connected-websites.html)

# getConnectedWebsites

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getConnectedWebsites(): `[`ConnectedWebsites`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ConnectedWebsites.html)

Suspend function, which returns all website where the current user used Telegram to log in.

**Return**
[ConnectedWebsites](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ConnectedWebsites.html) Contains a list of websites the current user is logged in with
Telegram.

