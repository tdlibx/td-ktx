---
title: ProxyKtx.ping - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ProxyKtx](index.html) / [ping](./ping.html)

# ping

`open suspend fun `[`Proxy`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Proxy.html)`.ping(): `[`Seconds`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Seconds.html)

Suspend function, which computes time needed to receive a response from a Telegram server
through a proxy. Can be called before authorization.

**Return**
[TdApi.Seconds](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Seconds.html) Contains a value representing a number of seconds.

