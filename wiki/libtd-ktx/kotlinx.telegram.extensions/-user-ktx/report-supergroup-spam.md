[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [UserKtx](index.md) / [reportSupergroupSpam](./report-supergroup-spam.md)

# reportSupergroupSpam

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.User.html)`.reportSupergroupSpam(supergroupId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, messageIds: `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which reports some messages from a user in a supergroup as spam; requires
administrator rights in the supergroup.

### Parameters

`supergroupId` - Supergroup identifier.

`messageIds` - Identifiers of messages sent in the supergroup by the user. This list must be
non-empty.