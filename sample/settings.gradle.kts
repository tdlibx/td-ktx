pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenLocal()
    }
    plugins {
        id("org.jetbrains.kotlin.multiplatform") version "2.2.21"
        id("com.android.application") version "8.13.1"
        id("org.jetbrains.compose") version "1.8.1"
        id("io.github.tdlibx.plugin") version "1.8.56-RC10"
        id("io.github.tdlibx.tdlib-xcframework") version "1.8.56-RC10"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenLocal()
    }
}

rootProject.name = "sample"

include(":app")
project(":app").projectDir = file("app")
