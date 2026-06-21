import java.net.URI
import org.gradle.api.publish.maven.MavenPublication
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.android.library)
    alias(libs.plugins.dokka)
    `maven-publish`
    kotlin("plugin.serialization")
}

group = "com.github.tdlibx"
version = "1.8.56"

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
    
    macosArm64()
    macosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":libtd"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
                implementation(libs.kotlinx.serialization.json)
            }
        }
    }
}

android {
    namespace = "kotlinx.telegram"
    compileSdk = 36

    sourceSets {
        getByName("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
        }
    }

    defaultConfig {
        minSdk = 21
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            consumerProguardFiles("proguard-rules.txt")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    lint {
        disable.add("InvalidPackage")
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

publishing {
    publications {
        withType<MavenPublication> {
            artifactId = "td-ktx" + (if (name == "kotlinMultiplatform") "" else "-$name")
        }
    }
}

tasks.named<DokkaTask>("dokkaGfm") {
    outputDirectory.set(file("$rootDir/wiki"))
    dokkaSourceSets.named("commonMain") {
        includes.from("src/commonMain/kotlin/kotlinx/telegram/index.md")
        externalDocumentationLink {
            url.set(URI("https://tdlibx.github.io/td/docs/").toURL())
        }
    }
}

tasks.register("dokkaMarkdown") {
    dependsOn(tasks.named("dokkaGfm"))
}
