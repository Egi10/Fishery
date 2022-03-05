/**
 * @created 05/03/22 12.20
 * @author Julsapargi Nursam
 * @project Fishery
 **/

object Dependencies {
    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Version.AndroidX.coreKtx}"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Version.AndroidX.lifecycleRuntimeKtx}"
        const val activityCompose =
            "androidx.activity:activity-compose:${Version.AndroidX.activityCompose}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Version.Compose.compose}"
        const val material = "androidx.compose.material:material:${Version.Compose.compose}"
        const val uiToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${Version.Compose.compose}"

        const val junit4 = "androidx.compose.ui:ui-test-junit4:${Version.Compose.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Version.Compose.compose}"
    }

    object Test {
        const val junit = "junit:junit:${Version.Test.junit}"
        const val junitExt = "androidx.test.ext:junit:${Version.Test.junitExt}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.Test.espressoCore}"
    }
}