---
title: ProxyKtx.getLink - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ProxyKtx](index.html) / [getLink](./get-link.html)

# getLink

`open suspend fun `[`Proxy`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Proxy.html)`.getLink(): `[`Text`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Text.html)

Suspend function, which returns an HTTPS link, which can be used to add a proxy. Available only
for SOCKS5 and MTProto proxies. Can be called before authorization.

**Return**
[TdApi.Text](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Text.html) Contains some text.

