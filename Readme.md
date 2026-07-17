# Telegram Flow for TDLib

Telegram Flow is a Kotlin-first extension toolkit for [TDLib](https://github.com/tdlib/td) that turns callback-based Telegram API calls into coroutines and flows. It keeps your client code concise while exposing idiomatic Compose- and coroutine-friendly APIs.

## Features
- **Coroutine wrappers** for every TDLib function so you can `suspend` instead of juggling callbacks.
- **Flow-based updates** that emit strongly typed Telegram updates with sensible defaults.
- **Extension interfaces** to organize API access around Telegram entities (users, chats, messages, etc.).
- **Compose-ready**: works seamlessly with `ViewModel` scopes and state flows.

## Setup
Add the library dependency from Maven Central:

```kotlin
implementation("io.github.tdlibx:td-ktx:1.8.56-RC5")
```

### Kotlin Version Requirement
**Important**: Version `1.8.56-RC5` is compiled with **Kotlin 2.2.21**. Due to KMP ABI stability constraints, your project must also use Kotlin `2.2.21`.

### Native Binaries (iOS)
The Maven artifact contains the Kotlin wrapper but **does not bundle the native TDLib C++ binaries** for iOS (as they are several hundred MBs). To link them in your iOS application:

1. Download `libtdjson.xcframework` (e.g., from [Swiftgram/TDLibFramework](https://github.com/Swiftgram/TDLibFramework)).
2. Place it in your `iosApp/libs/` directory.
3. Configure your `shared` module to link against the framework:

```kotlin
// shared/build.gradle.kts
val iosTargets = listOf(iosArm64(), iosSimulatorArm64(), iosX64())
iosTargets.forEach { target ->
    target.binaries.framework {
        val archPath = when (target.konanTarget.name) {
            "ios_arm64" -> "ios-arm64"
            "ios_x64", "ios_simulator_arm64" -> "ios-arm64_x86_64-simulator"
            else -> ""
        }
        val frameworkDir = project.rootProject.file("iosApp/libs/libtdjson.xcframework/$archPath").absolutePath
        linkerOpts("-F$frameworkDir", "-framework", "libtdjson", "-lz", "-lssl", "-lcrypto")
    }
}
```

## Getting started
1. Create a single `TelegramFlow` instance and keep it in a long-lived scope (e.g., via DI).
2. Attach a TDLib client once at startup:

```kotlin
val telegramFlow = TelegramFlow()
telegramFlow.attachClient()
```

3. Provide required TDLib parameters when prompted by the authorization state flow:

```kotlin
telegramFlow.authorizationStateFlow().collect { state ->
    if (state is TdApi.AuthorizationStateWaitTdlibParameters) {
        telegramFlow.setTdlibParameters(
            databaseDirectory = "/data/user/0/<your.package>/files/td",
            apiId = BuildConfig.TELEGRAM_APP_ID,
            apiHash = BuildConfig.TELEGRAM_APP_HASH,
            // ...other parameters
        )
    }
}
```

4. Send authentication information with coroutine calls:

```kotlin
telegramFlow.setAuthenticationPhoneNumber(phone, null)
telegramFlow.checkAuthenticationCode(code)
telegramFlow.checkAuthenticationPassword(password)
```

## Collecting updates
Every TDLib update has a matching flow extension. Example: tracking user presence changes.

```kotlin
telegramFlow.userStatusFlow().collect { status ->
    val user = telegramFlow.getUser(status.userId)
    // update UI with latest user status
}
```

For updates that only wrap a single value, the flow returns the inner type directly, e.g. `authorizationStateFlow()` emits `TdApi.AuthorizationState` instances.

## Calling Telegram functions
Each TDLib function is exposed as a suspending extension on `TelegramFlow`:

```kotlin
suspend fun fetchSelf(): TdApi.User = telegramFlow.getMe()
```

Explore the full API surface in the [generated docs](https://tdlibx.github.io/td-ktx/docs/libtd-ktx/).

## Samples
A minimal Compose sample lives in [`sample/app`](sample/app). It wires `TelegramFlow` with Hilt, demonstrates handling the authorization flow, and renders online users with Navigation Compose.

## Versioning & Testing Policy

### Versioning Scheme
Telegram Flow follows the underlying **Telegram SDK (TDLib) versioning** (e.g., `1.8.56`). 
* **Release Candidates**: Pre-release builds for testing against new TDLib versions are published with an `-RC` suffix (e.g., `1.8.56-RC1`).
* **Stable Releases**: Regular versions match the stable TDLib release they target.

### Dual-Dependency Testing Mechanism
The sample application in this repository is configured to automatically swap dependencies based on the build target:
* **Debug Builds**: Use the local `:libtd-ktx` module. This allows for immediate testing of local changes during development.
* **Release Builds**: Use the remote Maven Central artifact (matching the current library coordinates). This ensures that the release version of the sample app is always validated against the actual published binary.

This behavior is controlled in `sample/app/build.gradle.kts` by inspecting the Gradle task graph for any `release` tasks.

## License
This project is distributed under the Apache 2.0 License. See [LICENSE](LICENSE) for details.
