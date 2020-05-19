# Telegram Flow

Kotlin Coroutines API wrapper of the [TDLib](https://github.com/tdlib/td) (Telegram Database
 library)

## Using library

The main class of the library is TelegramFlow. It converts Telegram Java Updates classes to the
Kotlin Coroutine Flows and Telegram callback-style Functions to Kotlin Coroutine suspend functions

### Start using

1. Create instance of TelegramFlow
2. You can access flow of TdApi.Objects from the TelegramFlow instance and its flow extensions.
3. Call attachClient function of the TelegramFlow instance to connect it to the Telegram Client.
4. Now you can use numerous extension functions to send data to the Telegram API and collect data
 from flow extensions
 
### Using extensions classes

Library provides extension classes 