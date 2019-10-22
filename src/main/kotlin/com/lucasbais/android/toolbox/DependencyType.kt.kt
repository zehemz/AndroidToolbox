package com.lucasbais.android.toolbox

internal enum class DependencyType(val typeName: String) {
    IMPLEMENTATION("implementation"),
    TEST_IMPLEMENTATION("testImplementation"),
    ANDROID_TEST_IMPLEMENTATION("androidTestImplementation"),
    API("api"),
    KAPT("kapt")
}