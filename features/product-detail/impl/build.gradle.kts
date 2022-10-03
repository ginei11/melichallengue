plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
}

dependencies {
    implementation(project(":common:navigation"))
    implementation(project(":common:design-system:atoms"))
    implementation(project(":common:design-system:organism"))
    implementation(project(":domains:product-detail:api"))
    compose()
    lottie()
    hilt(withHiltNavigation = true)
    implementation(project(":features:product-detail:api"))
}
