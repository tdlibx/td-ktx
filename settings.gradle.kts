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
    }
}

rootProject.name = "Telegram Flow"

include(":libtd-ktx")

include(":libtd")
project(":libtd").projectDir = file("td-core-src/libtd")

include(":tdktxgen")
project(":tdktxgen").projectDir = file("td-generator-src/tdktxgen")

// This prevents the build from crashing due to missing secrets in the sample app.
if (true) {
    include(":sample:app")
    project(":sample:app").projectDir = file("sample/app")
}

