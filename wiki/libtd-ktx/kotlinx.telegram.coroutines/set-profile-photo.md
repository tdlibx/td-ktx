[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [setProfilePhoto](./set-profile-photo.md)

# setProfilePhoto

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.setProfilePhoto(photo: `[`InputFile`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.InputFile.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which uploads a new profile photo for the current user. If something changes,
updateUser will be sent.

### Parameters

`photo` - Profile photo to set. inputFileId and inputFileRemote may still be unsupported.