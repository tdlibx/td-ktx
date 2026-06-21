pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("org.jetbrains.kotlin.multiplatform") version "2.2.21"
        id("org.jetbrains.kotlin.jvm") version "2.2.21"
        id("org.jetbrains.kotlin.android") version "2.2.21"
        id("com.android.library") version "8.13.1"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "Telegram Flow"

include(":libtd-ktx")

include(":td-kmp-core")
project(":td-kmp-core").projectDir = file("td-core-src/td-kmp-core")

include(":libtd")
project(":libtd").projectDir = file("td-core-src/libtd")

include(":tdktxgen")
project(":tdktxgen").projectDir = file("td-generator-src/tdktxgen")

// This prevents the build from crashing due to missing secrets in the sample app,
// because JitPack servers set the 'JITPACK' environment variable to 'true'.
if (System.getenv("JITPACK") != "true") {
    include(":sample:app")
    project(":sample:app").projectDir = file("sample/app")
}

