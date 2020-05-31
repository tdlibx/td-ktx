---
title: getCurrentState - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getCurrentState](./get-current-state.html)

# getCurrentState

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getCurrentState(): `[`Updates`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Updates.html)

Suspend function, which returns all updates needed to restore current TDLib state, i.e. all
actual UpdateAuthorizationState/UpdateUser/UpdateNewChat and others. This is especially useful if
TDLib is run in a separate process. This is an offline method. Can be called before authorization.

**Return**
[Updates](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Updates.html) Contains a list of updates.

