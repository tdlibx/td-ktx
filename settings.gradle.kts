pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    plugins {
        id("org.jetbrains.kotlin.multiplatform") version "2.2.21"
        id("org.jetbrains.kotlin.jvm") version "2.2.21"
        id("org.jetbrains.kotlin.android") version "2.2.21"
        id("com.android.library") version "8.13.1"
        id("org.jetbrains.compose") version "1.8.1"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenLocal()
    }
}

rootProject.name = "Telegram Flow"

include(":libtd-ktx")

include(":libtd")
project(":libtd").projectDir = file("td-core-src/libtd")

include(":tdktxgen")
project(":tdktxgen").projectDir = file("td-generator-src/tdktxgen")

include(":tdjson-xcframework")
project(":tdjson-xcframework").projectDir = file("tdjson-xcframework")

include(":td-gradle-plugin")
project(":td-gradle-plugin").projectDir = file("td-gradle-plugin")

include(":td-bootstrap-settings-plugin")
project(":td-bootstrap-settings-plugin").projectDir = file("td-bootstrap-settings-plugin")

// This prevents the build from crashing due to missing secrets in the sample app.
// The sample is a standalone Gradle project to demonstrate consumer usage of
// io.github.tdlibx:td / io.github.tdlibx:td-ktx from Maven Central (and mavenLocal
// during local development). See sample/README.md for how to build it.


