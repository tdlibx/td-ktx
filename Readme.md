# Telegram Flow for TDLib

Telegram Flow is a Kotlin-first extension toolkit for [TDLib](https://github.com/tdlib/td) that turns callback-based Telegram API calls into coroutines and flows. It keeps your client code concise while exposing idiomatic Compose- and coroutine-friendly APIs.

## Features
- **Coroutine wrappers** for every TDLib function so you can `suspend` instead of juggling callbacks.
- **Flow-based updates** that emit strongly typed Telegram updates with sensible defaults.
- **Extension interfaces** to organize API access around Telegram entities (users, chats, messages, etc.).
- **Compose-ready**: works seamlessly with `ViewModel` scopes and state flows.

## Setup
Apply the bootstrap settings plugin in `settings.gradle.kts`:

```kotlin
plugins {
    id("io.github.tdlibx.plugin") version "1.8.56-RC10"
}
```

Then apply the project plugin and add the dependencies you need in each subproject that uses KMP:

```kotlin
// shared/build.gradle.kts
plugins {
    kotlin("multiplatform")
    id("io.github.tdlibx.tdlib-xcframework")  // version is declared above
}

dependencies {
    commonMain.implementation("io.github.tdlibx:td:1.8.56-RC10")
    commonMain.implementation("io.github.tdlibx:td-ktx:1.8.56-RC10")
}
```

The bootstrap plugin takes care of:
- Resolving `mavenCentral()` + `gradlePluginPortal()` repositories in both `pluginManagement` and `dependencyResolutionManagement`.
- Declaring `tdlib-xcframework` at the bootstrap version so consumers don't repeat it.

If you only need the raw bindings (no coroutines/Flows), depend on `td` alone and skip `td-ktx`.

### Kotlin Version Requirement
**Important**: Version `1.8.56-RC10` is compiled with **Kotlin 2.2.21**. Due to KMP ABI stability constraints, your project must also use Kotlin `2.2.21`.

### Native Binaries (iOS/macOS)
The setup above is the entire integration for iOS (`iosArm64`, `iosX64`, `iosSimulatorArm64`) and macOS (`macosArm64`, `macosX64`). The xcframework download, unpack, and `linkerOpts` injection are handled automatically by `id("io.github.tdlibx.tdlib-xcframework")` — no manual `linkerOpts` block or xcframework download required.

**Android**: The `td` AAR bundles native `.so` libraries (via `libtdjson.so` + JNI bridge in `jniLibs/<abi>/`) and is self-contained. Just the dependency is needed.

**JVM**: Provide `libtdjson.{so,dylib,dll}` on `java.library.path` at runtime.

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
