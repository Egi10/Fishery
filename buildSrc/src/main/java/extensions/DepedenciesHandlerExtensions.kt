package extensions

import org.gradle.api.artifacts.dsl.DependencyHandler


/**
 * @created 05/03/22 12.40
 * @author Julsapargi Nursam
 * @project Fishery
 **/

fun DependencyHandler.implementationsCompose() {
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.AndroidX.activityCompose)
    implementation(Dependencies.Compose.uiTooling)

    androidTestImplementation(Dependencies.Compose.junit4)
    debugImplementation(Dependencies.Compose.uiTooling)
}

fun DependencyHandler.implementationsHilt() {
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.compiler)

    // For instrumentation tests
    androidTestImplementation(Dependencies.Hilt.androidTesting)
    kaptAndroidTest(Dependencies.Hilt.testsCompiler)

    // For local unit tests
    testImplementation(Dependencies.Hilt.localAndroidTesting)
    kaptTest(Dependencies.Hilt.localTestCompiler)
}

fun DependencyHandler.implementationCoroutines() {
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Coroutines.android)
    testImplementation(Dependencies.Coroutines.test)
}

fun DependencyHandler.implementationsTest() {
    implementation(Dependencies.Test.espressoCore)
    implementation(Dependencies.Test.junit)
    implementation(Dependencies.Test.junitExt)
}

fun DependencyHandler.implementation(dependencyNotation: String) {
    add("implementation", dependencyNotation)
}

fun DependencyHandler.kapt(dependencyNotation: String) {
    add("kapt", dependencyNotation)
}

fun DependencyHandler.testImplementation(dependencyNotation: String) {
    add("testImplementation", dependencyNotation)
}

fun DependencyHandler.kaptTest(dependencyNotation: String) {
    add("kaptTest", dependencyNotation)
}

fun DependencyHandler.androidTestImplementation(dependencyNotation: String) {
    add("androidTestImplementation", dependencyNotation)
}

fun DependencyHandler.kaptAndroidTest(dependencyNotation: String) {
    add("kaptAndroidTest", dependencyNotation)
}

fun DependencyHandler.debugImplementation(dependencyNotation: String) {
    add("debugImplementation", dependencyNotation)
}