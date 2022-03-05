import extensions.implementationCoroutines
import extensions.implementationsHilt
import extensions.implementationsRoom
import extensions.implementationsTest

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.6.10-1.0.2"
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementationsTest()
    // Hilt
    implementationsHilt()
    // Coroutine
    implementationCoroutines()
    // Room
    implementationsRoom()
}

kapt {
    correctErrorTypes = true
}