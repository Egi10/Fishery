buildscript {
    dependencies {
        // other plugins...
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}")
        classpath("com.android.tools.build:gradle:7.1.2")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.kotlin.android") apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}