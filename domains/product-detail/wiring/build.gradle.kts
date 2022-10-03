plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdk
}

dependencies {
    api(project(":domains:product-detail:api"))
    implementation(project(":domains:product-detail:impl"))
    hilt()
    room()
    retrofit()
}
