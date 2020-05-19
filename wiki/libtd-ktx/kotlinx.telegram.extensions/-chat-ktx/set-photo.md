[libtd-ktx](../../index.md) / [kotlinx.telegram.extensions](../index.md) / [ChatKtx](index.md) / [setPhoto](./set-photo.md)

# setPhoto

`open suspend fun `[`Chat`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Chat.html)`.setPhoto(photo: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/InputFile.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which changes the photo of a chat. Supported only for basic groups,
supergroups and channels. Requires canChangeInfo rights. The photo will not be changed before
request to the server has been completed.

### Parameters

`photo` - New chat photo. You can use a zero InputFileId to delete the chat photo. Files
that are accessible only by HTTP URL are not acceptable.