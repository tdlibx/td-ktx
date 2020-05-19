[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [UserKtx](index.md) / [getInlineGameHighScores](./get-inline-game-high-scores.md)

# getInlineGameHighScores

`open suspend fun `[`User`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/User.html)`.getInlineGameHighScores(inlineMessageId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`GameHighScores`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/GameHighScores.html)

Suspend function, which returns game high scores and some part of the high score table in the
range of the specified user; for bots only.

### Parameters

`inlineMessageId` - Inline message identifier.

**Return**
[TdApi.GameHighScores](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/GameHighScores.html) Contains a list of game high scores.

