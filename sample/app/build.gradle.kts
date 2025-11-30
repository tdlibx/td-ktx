import org.gradle.api.GradleException

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.compose)
}

fun readTelegramCredential(propertyKey: String, envKey: String): String {
    val propertyValue = findProperty(propertyKey)?.toString()?.trim()
    if (!propertyValue.isNullOrEmpty()) {
        return propertyValue
    }

    val envValue = System.getenv(envKey)?.toString()?.trim()
    if (!envValue.isNullOrEmpty()) {
        return envValue
    }

    throw GradleException("Missing Telegram credential. Provide '$propertyKey' Gradle property or '$envKey' environment variable.")
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

        val telegramAppId = readTelegramCredential("telegramAppId", "TELEGRAM_APP_ID").toInt()
        val telegramAppHash = readTelegramCredential("telegramAppHash", "TELEGRAM_APP_HASH")

        buildConfigField("int", "TELEGRAM_APP_ID", telegramAppId.toString())
        buildConfigField("String", "TELEGRAM_APP_HASH", "\"$telegramAppHash\"")

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
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.constraintlayout.compose)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)

    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime.livedata)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    implementation(libs.coil.compose)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    debugImplementation(project(":libtd-ktx"))

    releaseImplementation(libs.td.ktx)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
}
