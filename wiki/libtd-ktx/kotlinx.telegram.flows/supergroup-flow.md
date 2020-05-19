[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [supergroupFlow](./supergroup-flow.md)

# supergroupFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.supergroupFlow(): Flow<`[`Supergroup`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html)`>`

emits [Supergroup](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Supergroup.html) if some data of a supergroup or a channel has changed. This update is
guaranteed to come before the supergroup identifier is returned to the client.

