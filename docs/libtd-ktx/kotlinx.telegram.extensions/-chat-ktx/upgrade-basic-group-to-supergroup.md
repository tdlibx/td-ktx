---
title: ChatKtx.upgradeBasicGroupToSupergroup - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [upgradeBasicGroupToSupergroup](./upgrade-basic-group-to-supergroup.html)

# upgradeBasicGroupToSupergroup

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.upgradeBasicGroupToSupergroup(): `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)

Suspend function, which creates a new supergroup from an existing basic group and sends a
corresponding messageChatUpgradeTo and messageChatUpgradeFrom; requires creator privileges.
Deactivates the original basic group.

**Return**
[TdApi.Chat](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html) A chat. (Can be a private chat, basic group, supergroup, or secret chat.)

