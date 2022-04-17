import extensions.implementationCoroutines
import extensions.implementationsCompose
import extensions.implementationsHilt
import extensions.implementationsTest

plugins {
    id("common-feature-plugins")
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