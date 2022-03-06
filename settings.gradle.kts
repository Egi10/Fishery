pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Fishery"
include(":app")
include(":libraries:network")
include(":libraries:abstraction")
include(":database")
include(":sync")
include(":features:home")
include(":commons:ui-theme")
