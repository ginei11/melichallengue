plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        minSdk = AppConfig.minSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
}

dependencies {
    implementation(project(":features:search:api"))
    implementation(project(":features:product-detail:api"))
    implementation(project(":common:navigation"))
    implementation(project(":common:design-system:atoms"))
    implementation(project(":common:design-system:organism"))
    implementation(project(":domains:search:api"))
    lottie()
    instrumentationTesting()
    compose()
    hilt(withHiltNavigation = true)
}
