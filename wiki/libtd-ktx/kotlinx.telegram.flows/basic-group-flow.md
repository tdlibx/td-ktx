[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [basicGroupFlow](./basic-group-flow.md)

# basicGroupFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.basicGroupFlow(): Flow<`[`BasicGroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/BasicGroup.html)`>`

emits [BasicGroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/BasicGroup.html) if some data of a basic group has changed. This update is guaranteed to come
before the basic group identifier is returned to the client.

