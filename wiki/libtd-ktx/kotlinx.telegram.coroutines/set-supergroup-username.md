[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setSupergroupUsername](./set-supergroup-username.md)

# setSupergroupUsername

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setSupergroupUsername(supergroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the username of a supergroup or channel, requires owner
privileges in the supergroup or channel.

### Parameters

`supergroupId` - Identifier of the supergroup or channel.

`username` - New value of the username. Use an empty string to remove the username.