plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.compose.multiplatform) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.dokka) apply false
    id("org.jetbrains.kotlin.multiplatform") version "2.2.21" apply false
    id("org.jetbrains.kotlin.jvm") version "2.2.21" apply false
    id("com.vanniktech.maven.publish") version "0.37.0" apply false
}

val secretsFile = rootProject.file("secrets.properties")
if (secretsFile.exists()) {
    val secrets = java.util.Properties()
    secretsFile.inputStream().use { secrets.load(it) }
    secrets.forEach { key, value ->
        extra.set(key.toString(), value)
    }
}


// Top-level build file where you can add configuration options common to all sub-projects/modules.

val kotlinVersion = libs.versions.kotlin.get()
extra["kotlin_version"] = kotlinVersion

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

findProject(":tdktxgen")?.run {
    afterEvaluate {
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
            compilerOptions.jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
}




