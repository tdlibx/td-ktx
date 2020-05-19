[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [MessageKtx](index.md) / [getPollVoters](./get-poll-voters.md)

# getPollVoters

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Message.html)`.getPollVoters(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, optionId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Users`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Users.html)

Suspend function, which returns users voted for the specified option in a non-anonymous polls.
For the optimal performance the number of returned users is chosen by the library.

### Parameters

`chatId` - Identifier of the chat to which the poll belongs.

`optionId` - 0-based identifier of the answer option.

`offset` - Number of users to skip in the result; must be non-negative.

`limit` - The maximum number of users to be returned; must be positive and can't be greater
than 50. Fewer users may be returned than specified by the limit, even if the end of the voter
list has not been reached.

**Return**
[TdApi.Users](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Users.html) Represents a list of users.

