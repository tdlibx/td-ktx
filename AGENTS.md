# AGENTS.md

## Project overview

Kotlin Multiplatform wrapper around Telegram TDLib that converts callback-based API calls into coroutines and Flows. Published as `io.github.tdlibx:td-ktx` and `io.github.tdlibx:td`.

## Module structure

- `:libtd` — KMP bindings for the native TDLib C++ library (JNI on Android, cinterop on iOS/macOS). Source lives in `td-core-src/libtd/`.
- `:libtd-ktx` — Coroutine/Flow extensions over `:libtd`. Source lives in `libtd-ktx/`.
- `:sample:app` — Compose Multiplatform sample client (Android, iOS, macOS). Source lives in `sample/app/`. Note: the sample now lives under its own standalone Gradle build at `sample/` (with its own wrapper) so it can demonstrate pure consumer usage without depending on local copies of `:libtd` / `:libtd-ktx`.
- `:tdktxgen` — Code generator that parses `TdApi.java` and emits Kotlin extension files into `libtd-ktx/src/commonMain/`. Source lives in `td-generator-src/tdktxgen/`.

## Build & run

```bash
# Full build (Android targets)
./gradlew assembleRelease

# Sample app — built from the `sample/` directory (standalone consumer):
cd sample
./gradlew :app:installDebug
./gradlew :app:runDebugExecutableMacosArm64

# Regenerate Kotlin wrappers after TDLib API changes
cd td-generator-src
./tdktxgen/generate.sh
# Outputs go to libtd-ktx/src/commonMain/kotlin/org/drinkless/tdlib/generated/
```

## Testing

```bash
# Unit tests (common)
./gradlew allTests

# Sample UI + integration tests (built from the `sample/` directory):
cd sample
./gradlew :app:connectedDebugAndroidTest

# Integration test requiring Telegram test DC credentials
cd sample
./gradlew :app:connectedDebugAndroidTest \
  -Pandroid.testInstrumentationRunnerArguments.telegram_app_id=YOUR_ID \
  -Pandroid.testInstrumentationRunnerArguments.telegram_app_hash=YOUR_HASH
```

## Key conventions

- **Kotlin 2.2.21** is pinned everywhere. Do not upgrade without verifying ABI compatibility.
- **JVM target 17** across all modules.
- Version is kept in sync: `libtd-ktx/build.gradle.kts`, `td-core-src/libtd/build.gradle.kts`, `td-gradle-plugin/build.gradle.kts`, `td-bootstrap-settings-plugin/build.gradle.kts`, `gradle/libs.versions.toml`, and `sample/gradle.properties` (`tdlibx.tdlibJsonVersion`) all declare `1.8.56-RC10`.
- Generated files live at `libtd-ktx/src/commonMain/kotlin/org/drinkless/tdlib/generated/` — do not edit by hand; regenerate via `:tdktxgen`.
- Sample app is a standalone Gradle project (own wrapper, own `settings.gradle.kts`) that consumes `io.github.tdlibx:td-ktx` + `io.github.tdlibx:td` from Maven Central / Maven Local. It depends only on the published bootstrap plugin (`io.github.tdlibx.plugin`) and `io.github.tdlibx.tdlib-xcframework` for native linking — no local git dependencies on `:libtd` / `:libtd-ktx`.
- Android native builds require NDK `30.0.14904198` and CMake `3.22.1`.
- Native TDLib binaries are NOT in the repo for iOS. They are downloaded at build time from `io.github.tdlibx:td-libtdjson:<version>` by the xcframework plugin via Maven Central / Maven Local.
- macOS native libs are NOT in the repo. They are also downloaded at build time via the xcframework plugin (was: `td-core-src/libtd/native_libs/macos/` before the cleanup).
- Secrets (API keys etc.) go in `secrets.properties`; loaded at root build time via `build.gradle.kts`.
