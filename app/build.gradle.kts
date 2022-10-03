plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version Versions.SERIALIZATION_PLUGIN
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.meli.shop"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    compose()
    hilt()
    unitTesting()
    implementation(project(":features:navigation:api"))
    implementation(project(":features:navigation:impl"))
    implementation(project(":features:navigation:wiring"))

    implementation(project(":features:search:api"))
    implementation(project(":features:search:impl"))
    implementation(project(":features:search:wiring"))

    implementation(project(":features:product-detail:api"))
    implementation(project(":features:product-detail:impl"))
    implementation(project(":features:product-detail:wiring"))

    implementation(project(":common:network"))
    implementation(project(":common:navigation"))
    implementation(project(":common:design-system:atoms"))

    implementation(project(":domains:search:wiring"))
    implementation(project(":domains:product-detail:wiring"))
}
