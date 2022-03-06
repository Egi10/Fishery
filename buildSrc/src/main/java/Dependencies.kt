/**
 * @created 05/03/22 12.20
 * @author Julsapargi Nursam
 * @project Fishery
 **/

object Dependencies {
    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Version.AndroidX.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.AndroidX.appCompat}"
        const val material = "com.google.android.material:material:${Version.AndroidX.material}"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Version.AndroidX.lifecycleRuntimeKtx}"
        const val activityCompose =
            "androidx.activity:activity-compose:${Version.AndroidX.activityCompose}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.AndroidX.lifecycleRuntimeKtx}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Version.AndroidX.hilt}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Version.Compose.compose}"
        const val material = "androidx.compose.material:material:${Version.Compose.compose}"
        const val uiToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${Version.Compose.compose}"

        const val junit4 = "androidx.compose.ui:ui-test-junit4:${Version.Compose.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Version.Compose.compose}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit.retrofit}"
        const val moshi = "com.squareup.retrofit2:converter-moshi:${Version.Retrofit.retrofit}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"

        // For instrumentation tests
        const val androidTesting = "com.google.dagger:hilt-android-testing:${Version.hilt}"
        const val testsCompiler = "com.google.dagger:hilt-compiler:${Version.hilt}"

        // For local unit tests
        const val localAndroidTesting = "com.google.dagger:hilt-android-testing:${Version.hilt}"
        const val localTestCompiler = "com.google.dagger:hilt-compiler:${Version.hilt}"

        // Hilt Worker
        const val worker = "androidx.hilt:hilt-work:${Version.AndroidX.hilt}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Version.room}"
        const val compiler = "androidx.room:room-compiler:${Version.room}"
        const val ktx = "androidx.room:room-ktx:${Version.room}"
        const val test = "androidx.room:room-testing:${Version.room}"
    }

    object WorkManager {
        const val runtime = "androidx.work:work-runtime-ktx:${Version.workManager}"
        const val test = "androidx.work:work-testing:${Version.workManager}"
    }

    object Test {
        const val junit = "junit:junit:${Version.Test.junit}"
        const val junitExt = "androidx.test.ext:junit:${Version.Test.junitExt}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.Test.espressoCore}"
    }
}