---
title: sendCallRating - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [sendCallRating](./send-call-rating.html)

# sendCallRating

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.sendCallRating(callId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, rating: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, comment: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, problems: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`CallProblem`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/CallProblem.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which sends a call rating.

### Parameters

`callId` - Call identifier.

`rating` - Call rating; 1-5.

`comment` - An optional user comment if the rating is less than 5.

`problems` - List of the exact types of problems with the call, specified by the user.