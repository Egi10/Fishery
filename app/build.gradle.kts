import extensions.implementationsCompose
import extensions.implementationsHilt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.Compose.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.lifecycleRuntimeKtx)
    // Compose
    implementationsCompose()
    // Hilt
    implementationsHilt()
    implementation(Dependencies.Hilt.worker)
    kapt(Dependencies.AndroidX.hiltCompiler)
    // Test
    androidTestImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.espressoCore)
    // Database
    implementation(project(Module.database))
    // Network
    implementation(project(Module.Libraries.network))
    // Abstractions
    implementation(project(Module.Libraries.abstraction))
    // Sync
    implementation(project(Module.sync))
}

kapt {
    correctErrorTypes = true
}