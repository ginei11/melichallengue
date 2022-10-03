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
rootProject.name = "Mercadolibre"
include(":app")


fun includeFeatures(vararg featureName: String) {
    featureName.forEach {
        include(":features:$it:api", ":features:$it:impl", ":features:$it:wiring")
    }
}

fun includeCommons(vararg moduleName: String) {
    moduleName.forEach {
        include(":common:$it")
    }
}

fun includeDomains(vararg moduleName: String) {
    moduleName.forEach {
        include(":domains:$it:api", ":domains:$it:impl", ":domains:$it:wiring")
    }
}

includeDomains("search", "product-detail")
includeFeatures("navigation", "search", "product-detail")
includeCommons( "navigation", "design-system:atoms", "design-system:organism", "network")
