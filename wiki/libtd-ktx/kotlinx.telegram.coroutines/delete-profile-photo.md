[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [deleteProfilePhoto](./delete-profile-photo.md)

# deleteProfilePhoto

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.deleteProfilePhoto(profilePhotoId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes a profile photo. If something changes, updateUser will be sent.

### Parameters

`profilePhotoId` - Identifier of the profile photo to delete.