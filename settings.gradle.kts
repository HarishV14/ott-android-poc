pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "flimix-android-poc"
include(
    ":app-mobile",
    ":app-tv",
    ":core",
    ":schema",
    ":renderer",
    ":designsystem",
    ":features:home:shared",
    ":features:home:mobile",
    ":features:home:tv",
)
 
