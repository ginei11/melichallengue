import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val COMPOSE_UI_TOOLING_PREVIEW =
        "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val COMPOSE_NAVIGATION =
        "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"

    // Material
    const val MATERIAL3 = "androidx.compose.material3:material3:${Versions.MATERIAL3}"

    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"

    // DI
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_NAVIGATION_COMPOSE =
        "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION_COMPOSE}"

    // retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"

    // Testing
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"

    const val COIL = "io.coil-kt:coil-compose:${Versions.COIL}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"

    // Coroutines
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"

    //Room
    const val ROOM_RUNTIME = "androidx.room:room-rxjava3:${Versions.ROOM}"
    const val ROOM_KTX= "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"

    // Accompanist
    const val ACCOMPANIST_PAGER = "com.google.accompanist:accompanist-pager:${Versions.ACCOMPANIST}"
    const val ACCOMPANIST_PAGER_INDICATORS =
        "com.google.accompanist:accompanist-pager-indicators:${Versions.ACCOMPANIST}"

    const val LOTTIE =
        "com.airbnb.android:lottie-compose:${Versions.LOTTIE}"
    const val ANDROIDX_COMPOSE_UI_TEST_MANIFEST =
        "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE}"
    const val COMPOSE_UI_TEST_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    const val MOCKK_ANDROID = "io.mockk:mockk-android:${Versions.MOCKK}"
}

fun DependencyHandler.hilt(withHiltNavigation: Boolean = false) {
    add("implementation", Dependencies.HILT)
    add("kapt", Dependencies.HILT_COMPILER)
    if (withHiltNavigation) {
        add("implementation", Dependencies.HILT_NAVIGATION_COMPOSE)
    }
}

fun DependencyHandler.retrofit() {
    add("implementation", Dependencies.RETROFIT)
    add("implementation", Dependencies.RETROFIT_CONVERTER)
}

fun DependencyHandler.lottie() {
    add("implementation", Dependencies.LOTTIE)
}

fun DependencyHandler.room() {
    add("implementation", Dependencies.ROOM_RUNTIME)
    add("implementation", Dependencies.ROOM_KTX)
    add("kapt", Dependencies.ROOM_COMPILER)
}

/**
 * Implement all dependencies for jetpack compose.
 * @param withPreviewImplemented Boolean to debugImplement the compose UI tooling lib.
 * @param useMaterial Define if use Compose material lib. (Used by default)
 */
fun DependencyHandler.compose(
    withPreviewImplemented: Boolean = true,
    useMaterial: Boolean = true
) {
    add("implementation", Dependencies.COMPOSE_UI)
    add("implementation", Dependencies.COMPOSE_UI_TOOLING_PREVIEW)
    add("implementation", Dependencies.ACTIVITY_COMPOSE)
    add("implementation", Dependencies.COMPOSE_NAVIGATION)
    add("implementation", Dependencies.MATERIAL3)

    if (useMaterial) {
        add("implementation", Dependencies.COMPOSE_MATERIAL)
    }

    if (withPreviewImplemented) {
        add("debugImplementation", Dependencies.COMPOSE_UI_TOOLING)
    }
}

fun DependencyHandler.unitTesting() {
    add("testImplementation", Dependencies.MOCKK)
    add("testImplementation", Dependencies.JUNIT)
    add("testImplementation", Dependencies.COROUTINES_TEST)
}

fun DependencyHandler.instrumentationTesting() {
    add("debugImplementation", Dependencies.ANDROIDX_COMPOSE_UI_TEST_MANIFEST)
    add("androidTestImplementation", Dependencies.COMPOSE_UI_TEST_JUNIT)
    add("androidTestImplementation", Dependencies.MOCKK_ANDROID)
}
