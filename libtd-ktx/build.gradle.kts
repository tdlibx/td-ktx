import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URI

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.android.library)
    alias(libs.plugins.dokka)
    kotlin("plugin.serialization")
    id("com.vanniktech.maven.publish")
}

group = "io.github.tdlibx"
version = "1.8.56-RC10"

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    jvm() // For Desktop (JVM)

    macosArm64()
    macosX64()

    iosArm64()
    iosSimulatorArm64()
    iosX64()

    sourceSets {
        commonMain {
            dependencies {
                api(project(":libtd"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
                implementation(libs.kotlinx.serialization.json)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.1")
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

mavenPublishing {
    coordinates("io.github.tdlibx", "td-ktx", "1.8.56-RC10")

    pom {
        name.set("td-ktx")
        description.set("Kotlin Coroutines and Flows extensions for Telegram API TDLib")
        inceptionYear.set("2026")
        url.set("https://github.com/tdlibx/td-ktx")
        licenses {
            license {
                name.set("The Apache Software License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("tdlibx")
                name.set("tdlibx Contributors")
            }
        }
        scm {
            url.set("https://github.com/tdlibx/td-ktx")
            connection.set("scm:git:git://github.com/tdlibx/td-ktx.git")
            developerConnection.set("scm:git:ssh://git@github.com/tdlibx/td-ktx.git")
        }
    }

    // Configure targeting the modern Sonatype Central Portal
    publishToMavenCentral()

    // Sign all generated multiplatform target publications
    signAllPublications()
}
