val isReleaseBuild = gradle.startParameter.taskNames.any { it.contains("release", ignoreCase = true) }

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
    kotlin("multiplatform")
}

kotlin {
    androidTarget {
        compilations.all {
            compilerOptions.configure {
                jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
            }
        }
    }
    macosArm64 {
        binaries {
            executable {
                baseName = "sample-app"
                entryPoint = "com.telegramflow.example.main"
                linkerOpts("-L${project.rootDir.absolutePath}/td-core-src/libtd/native_libs/macos", "-ltdjson", "-lc++")
            }
        }
    }
    iosSimulatorArm64 {
        binaries.framework {
            baseName = "shared"
            isStatic = false
            linkerOpts("-L${project.rootDir.absolutePath}/td-core-src/libtd/native_libs/ios-simulator", "-ltdjson", "-lc++")
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                if (isReleaseBuild) {
                    implementation(libs.td.ktx)
                    implementation(libs.tdlib)
                } else {
                    implementation(project(":libtd-ktx"))
                    implementation(project(":libtd"))
                }
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.materialIconsExtended)
            }
        }

        val androidMain by getting {
            dependencies {
                // Android-specific deps not provided by Compose Multiplatform
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.hilt.navigation.compose)
                implementation(libs.androidx.navigation.compose)
                implementation(libs.hilt.android)
                implementation(libs.kotlinx.coroutines.android)
                // Material 1 (used by the existing theme: darkColors, lightColors, Shapes, Typography)
                implementation(libs.androidx.compose.material)
                // Material icons extended (Visibility, VisibilityOff, etc.)
                implementation(libs.androidx.compose.material.icons.extended)
                // Required for @Preview annotation resolution during kapt
                implementation(libs.androidx.compose.ui.tooling)
            }
        }

        val androidUnitTest by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.test)
                implementation(libs.turbine)
                implementation(kotlin("test"))
            }
        }

        val macosArm64Main by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
            }
        }

        val iosSimulatorArm64Main by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
            }
        }
    }
}

android {
    namespace = "com.telegramflow.example"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.telegramflow.example"
        minSdk = 24
        targetSdk = 36
        versionCode = 20240621
        versionName = "0.1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
        debug {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    sourceSets {
        getByName("androidTest") {
            java.srcDirs("src/androidInstrumentedTest/kotlin")
            manifest.srcFile("src/androidInstrumentedTest/AndroidManifest.xml")
        }
    }
}

dependencies {
    // Hilt annotation processor – must be in top-level dependencies for kapt to pick it up in KMP
    add("kapt", libs.hilt.compiler)

    // Android test dependencies
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.kotlinx.coroutines.core)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Additional Android UI runtime libraries
    implementation(libs.coil.compose)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
}

// ── macOS: copy libtdjson into the Frameworks folder that @rpath resolves to ──
// The dylib's embedded install name is @rpath/libtdjson.1.8.65.dylib, but the file
// on disk is named libtdjson.dylib. We copy it with the expected versioned name so
// dyld can find it when the executable runs.
val copyMacosLibtdjson by tasks.registering(Copy::class) {
    // The binary's LC_RPATH is @executable_path/../Frameworks, so relative to
    // build/bin/macosArm64/debugExecutable/sample-app.kexe that resolves to
    // build/bin/macosArm64/Frameworks/ (one level up from debugExecutable/).
    val frameworksDir = layout.buildDirectory.dir("bin/macosArm64/Frameworks")
    val libsSrc = project.rootDir.resolve("td-core-src/libtd/native_libs/macos/libtdjson.dylib")
    from(libsSrc)
    into(frameworksDir)
    rename { "libtdjson.1.8.65.dylib" }
}

tasks.matching { it.name == "runDebugExecutableMacosArm64" }.configureEach {
    dependsOn(copyMacosLibtdjson)
}
