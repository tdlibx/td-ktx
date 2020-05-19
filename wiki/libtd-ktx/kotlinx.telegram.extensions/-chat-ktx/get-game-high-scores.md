[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [getGameHighScores](./get-game-high-scores.md)

# getGameHighScores

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.getGameHighScores(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`GameHighScores`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/GameHighScores.html)

Suspend function, which returns the high scores for a game and some part of the high score
table in the range of the specified user; for bots only.

### Parameters

`messageId` - Identifier of the message.

`userId` - User identifier.

**Return**
[TdApi.GameHighScores](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/GameHighScores.html) Contains a list of game high scores.

