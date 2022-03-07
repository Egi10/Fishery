import extensions.implementationCoroutines
import extensions.implementationsCompose
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
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.material)
    implementation(Dependencies.AndroidX.viewModel)
    // Coroutine
    implementationCoroutines()
    // Hilt
    implementationsHilt()
    // Compose
    implementationsCompose()
    // ViewModelCompose
    implementation(Dependencies.AndroidX.viewModelCompose)
    // Test
    implementationsTest()
    // Database
    implementation(project(Module.database))
    // Abstraction
    implementation(project(Module.Libraries.abstraction))
    // Ui-View
    implementation(project(Module.Commons.uiTheme))
    // Sync
    implementation(project(Module.sync))
    // Network
    implementation(project(Module.Libraries.network))
}

kapt {
    correctErrorTypes = true
}