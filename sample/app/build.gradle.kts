plugins {
    alias(libs.plugins.android.application)
    kotlin("multiplatform")
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
}

kotlin {
    androidTarget()
    macosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":td-ktx"))
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
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.compose.ui)
                implementation(libs.androidx.compose.material)
                implementation(libs.androidx.compose.material3)
                implementation(libs.androidx.hilt.navigation.compose)
                implementation(libs.hilt.android)
                kapt(libs.hilt.compiler)
                implementation(libs.kotlinx.coroutines.android)
            }
        }
        val macosMain by getting {
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
    kotlinOptions { jvmTarget = "17" }
    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = libs.versions.compose.get() }
    packaging { resources { excludes.add("/META-INF/{AL2.0,LGPL2.1}") } }
}

dependencies {
    // Android test dependencies
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // UI/runtime libraries
    implementation(libs.coil.compose)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
}
