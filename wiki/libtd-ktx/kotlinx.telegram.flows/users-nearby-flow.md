[libtd-ktx](../index.md) / [kotlinx.telegram.flows](index.md) / [usersNearbyFlow](./users-nearby-flow.md)

# usersNearbyFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.usersNearbyFlow(): Flow<`[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`ChatNearby`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.ChatNearby.html)`>>`

emits usersNearby [ChatNearby[]] if list of users nearby has changed. The update is sent only 60
seconds after a successful searchChatsNearby request.

