---
title: getAuthorizationState - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getAuthorizationState](./get-authorization-state.html)

# getAuthorizationState

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getAuthorizationState(): `[`AuthorizationState`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/AuthorizationState.html)

Suspend function, which returns the current authorization state; this is an offline request. For
informational purposes only. Use updateAuthorizationState instead to maintain the current
authorization state.

**Return**
[AuthorizationState](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/AuthorizationState.html) This class is an abstract base class.

