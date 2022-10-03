plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
    compose()
    implementation(Dependencies.APP_COMPAT)
    implementation(Dependencies.ACCOMPANIST_PAGER)
    implementation(Dependencies.ACCOMPANIST_PAGER_INDICATORS)
    implementation(Dependencies.COIL)
    implementation(project(":common:design-system:atoms"))
}
