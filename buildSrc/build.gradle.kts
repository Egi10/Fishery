plugins {
    `kotlin-dsl`
    /** @see [https://plugins.gradle.org/plugin/org.gradle.kotlin.kotlin-dsl.precompiled-script-plugins] **/
    `kotlin-dsl-precompiled-script-plugins`
    /** @see [https://kotlinlang.org/docs/gradle.html#targeting-the-jvm] **/
    kotlin("jvm") version "1.6.10"
}

/**
 * @see [https://kotlinlang.org/docs/gradle.html#kotlin-and-java-sources]
 */
sourceSets {
    main {
        java.srcDirs(listOf("src/main"))
    }
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

dependencies {
    // in order to be able to use "kotlin-android" in the common script
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")

    // in order to recognize the "plugins" block in the common script
    implementation("com.android.tools.build:gradle:7.1.2")

    // in order to recognize the "android" block in the common script
    implementation("com.android.tools.build:gradle-api:7.1.2")

    implementation("com.google.dagger:hilt-android-gradle-plugin:2.41")
}