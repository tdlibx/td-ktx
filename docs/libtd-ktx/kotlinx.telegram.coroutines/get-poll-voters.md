---
title: getPollVoters - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getPollVoters](./get-poll-voters.html)

# getPollVoters

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getPollVoters(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, optionId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Users`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Users.html)

Suspend function, which returns users voted for the specified option in a non-anonymous polls.
For the optimal performance the number of returned users is chosen by the library.

### Parameters

`chatId` - Identifier of the chat to which the poll belongs.

`messageId` - Identifier of the message containing the poll.

`optionId` - 0-based identifier of the answer option.

`offset` - Number of users to skip in the result; must be non-negative.

`limit` - The maximum number of users to be returned; must be positive and can't be greater
than 50. Fewer users may be returned than specified by the limit, even if the end of the voter list
has not been reached.

**Return**
[Users](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Users.html) Represents a list of users.

