---
title: ChatKtx.getLoginUrlInfo - libtd-ktx
---

[libtd-ktx](../../index.html) / [kotlinx.telegram.extensions](../index.html) / [ChatKtx](index.html) / [getLoginUrlInfo](./get-login-url-info.html)

# getLoginUrlInfo

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.getLoginUrlInfo(messageId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`, buttonId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`LoginUrlInfo`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LoginUrlInfo.html)

Suspend function, which returns information about a button of type
inlineKeyboardButtonTypeLoginUrl. The method needs to be called when the user presses the button.

### Parameters

`messageId` - Message identifier of the message with the button.

`buttonId` - Button identifier.

**Return**
[TdApi.LoginUrlInfo](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/LoginUrlInfo.html) This class is an abstract base class.

