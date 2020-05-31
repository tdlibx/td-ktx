---
title: basicGroupFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [basicGroupFlow](./basic-group-flow.html)

# basicGroupFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.basicGroupFlow(): Flow<`[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html)`>`

emits [BasicGroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.BasicGroup.html) if some data of a basic group has changed. This update is guaranteed to come
before the basic group identifier is returned to the client.

