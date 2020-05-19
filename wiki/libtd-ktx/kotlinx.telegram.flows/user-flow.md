[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [userFlow](./user-flow.md)

# userFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.userFlow(): Flow<`[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html)`>`

emits [User](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html) if some data of a user has changed. This update is guaranteed to come before the
user identifier is returned to the client.

