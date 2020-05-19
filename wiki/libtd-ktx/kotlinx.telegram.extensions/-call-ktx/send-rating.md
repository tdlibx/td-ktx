[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [CallKtx](index.md) / [sendRating](./send-rating.md)

# sendRating

`open suspend fun `[`Call`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Call.html)`.sendRating(rating: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, comment: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, problems: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`CallProblem`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.CallProblem.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sends a call rating.

### Parameters

`rating` - Call rating; 1-5.

`comment` - An optional user comment if the rating is less than 5.

`problems` - List of the exact types of problems with the call, specified by the user.