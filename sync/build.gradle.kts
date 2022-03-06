import extensions.implementationCoroutines
import extensions.implementationsHilt
import extensions.implementationsTest

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
    implementation(Dependencies.Hilt.worker)
    kapt(Dependencies.AndroidX.hiltCompiler)
    // Coroutine
    implementationCoroutines()
    // WorkManager
    api(Dependencies.WorkManager.runtime)
    androidTestApi(Dependencies.WorkManager.test)
    // Network
    implementation(project(Module.Libraries.network))
    // Abstraction
    implementation(project(Module.Libraries.abstraction))
    // Database
    implementation(project(Module.database))
}

kapt {
    correctErrorTypes = true
}