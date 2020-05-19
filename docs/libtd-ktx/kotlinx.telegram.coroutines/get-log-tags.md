---
title: getLogTags - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [getLogTags](./get-log-tags.html)

# getLogTags

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.getLogTags(): `[`LogTags`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LogTags.html)

Suspend function, which returns list of available TDLib internal log tags, for example,
[&amp;quot;actor&amp;quot;,&amp;quot;binlog&amp;quot;,&amp;quot;connections&amp;quot;,&amp;quot;notifications&amp;quot;,&amp;quot;proxy&amp;quot;](#). This is an offline method. Can be called before authorization. Can be called
synchronously.

**Return**
[LogTags](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LogTags.html) Contains a list of available TDLib internal log tags.

