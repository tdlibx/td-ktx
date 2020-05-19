[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [testReturnError](./test-return-error.md)

# testReturnError

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.testReturnError(error: `[`Error`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Error.html)`?): `[`Error`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Error.html)

Suspend function, which returns the specified error and ensures that the Error object is used;
for testing only. This is an offline method. Can be called before authorization. Can be called
synchronously.

### Parameters

`error` - The error to be returned.

**Return**
[Error](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi/Error.html) An object of this type can be returned on every function call, in case of an
error.

