pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    plugins {
        id("org.jetbrains.kotlin.jvm") version "2.2.21"
    }
}
