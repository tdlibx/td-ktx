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
    macosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":libtd-ktx"))
                implementation(project(":libtd"))
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
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
}

dependencies {
    // Hilt annotation processor – must be in top-level dependencies for kapt to pick it up in KMP
    add("kapt", libs.hilt.compiler)

    // Android test dependencies
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Additional Android UI runtime libraries
    implementation(libs.coil.compose)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
}
