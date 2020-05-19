[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [MessageKtx](index.md) / [getGameHighScores](./get-game-high-scores.md)

# getGameHighScores

`open suspend fun `[`Message`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.Message.html)`.getGameHighScores(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, userId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`GameHighScores`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.GameHighScores.html)

Suspend function, which returns the high scores for a game and some part of the high score
table in the range of the specified user; for bots only.

### Parameters

`chatId` - The chat that contains the message with the game.

`userId` - User identifier.

**Return**
[TdApi.GameHighScores](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.GameHighScores.html) Contains a list of game high scores.

