---
title: deleteProfilePhoto - libtd-ktx
---

[libtd-ktx](../index.html) / [kotlinx.telegram.coroutines](index.html) / [deleteProfilePhoto](./delete-profile-photo.html)

# deleteProfilePhoto

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.html)`.deleteProfilePhoto(profilePhotoId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Suspend function, which deletes a profile photo. If something changes, updateUser will be sent.

### Parameters

`profilePhotoId` - Identifier of the profile photo to delete.