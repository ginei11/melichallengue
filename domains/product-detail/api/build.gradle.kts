plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = AppConfig.compileSdk
}

dependencies {

    implementation(Dependencies.COROUTINES)
    retrofit()
}
