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
    api(project(":domains:search:api"))
    implementation(project(":domains:search:impl"))
    hilt()
    room()
    retrofit()
}
