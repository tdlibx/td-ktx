[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [toggleSupergroupSignMessages](./toggle-supergroup-sign-messages.md)

# toggleSupergroupSignMessages

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.toggleSupergroupSignMessages(supergroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, signMessages: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which toggles sender signatures messages sent in a channel; requires
canChangeInfo rights.

### Parameters

`supergroupId` - Identifier of the channel.

`signMessages` - New value of signMessages.