[libtd-ktx](../index.md) / [kotlinx.telegram.coroutines](index.md) / [getOption](./get-option.md)

# getOption

`suspend fun `[`TelegramFlow`](../kotlinx.telegram.core/-telegram-flow/index.md)`.getOption(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`OptionValue`](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.OptionValue.html)

Suspend function, which returns the value of an option by its name. (Check the list of available
options on https://core.telegram.org/tdlib/options.) Can be called before authorization.

### Parameters

`name` - The name of the option.

**Return**
[OptionValue](https://tdlibx.github.io/td/docs/org/drinkless/td/libcore/telegram/TdApi.OptionValue.html) This class is an abstract base class.

