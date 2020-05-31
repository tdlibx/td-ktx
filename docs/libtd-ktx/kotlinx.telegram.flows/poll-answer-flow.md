---
title: pollAnswerFlow - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.flows](index.html) / [pollAnswerFlow](./poll-answer-flow.html)

# pollAnswerFlow

`fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.pollAnswerFlow(): Flow<`[`UpdatePollAnswer`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdatePollAnswer.html)`>`

emits [UpdatePollAnswer](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.UpdatePollAnswer.html) if a user changed the answer to a poll; for bots only.

