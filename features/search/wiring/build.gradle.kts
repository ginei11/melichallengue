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
    hilt()
    implementation(project(":features:search:api"))
    implementation(project(":features:search:impl"))
    implementation(project(":common:navigation"))

}
