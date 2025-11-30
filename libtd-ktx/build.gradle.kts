import java.net.URL
import org.gradle.api.publish.maven.MavenPublication
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.dokka)
    `maven-publish`
}

group = "com.github.akrafts-gpt"
version = "1.8.56-beta5"

android {
    namespace = "kotlinx.telegram"
    compileSdk = 36

    defaultConfig {
        minSdk = 21
        targetSdk = 36
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

    kotlinOptions {
        jvmTarget = "17"
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

dependencies {
    api(libs.tdlib)
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.core)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = project.group.toString()
                artifactId = "td-ktx"
                version = project.version.toString()
            }
        }
    }
}

tasks.register<DokkaTask>("dokkaMarkdown") {
    outputFormat.set("gfm")
    outputDirectory.set(file("$rootDir/wiki"))
    dokkaSourceSets.named("main") {
        includes.from("src/main/java/kotlinx/telegram/index.md")
        externalDocumentationLink {
            url.set(URL("https://tdlibx.github.io/td/docs/"))
        }
    }
}
