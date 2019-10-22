package com.lucasbais.android.toolbox

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.artifacts.dsl.RepositoryHandler

fun RepositoryHandler.recommendRepositories() {
    google()
    jcenter()
    mavenCentral()
    mavenLocal()
}

fun DependencyHandler.recommended(recommended: GradleDependencyProvider) {
    kaptRecommended(recommended)
    apiRecommended(recommended)
    implementationRecommended(recommended)
    testImplementationRecommended(recommended)
    androidTestImplementationRecommended(recommended)
}

internal fun DependencyHandler.apiRecommended(recommended: GradleDependencyProvider) {
    recommended.recommendedGradleDependencyList().forEach { dep ->
        add(DependencyType.API.typeName, dep.toString())
    }
}

internal fun DependencyHandler.implementationRecommended(recommended: GradleDependencyProvider) {
    recommended.recommendedGradleDependencyList().forEach { dep ->
        add(DependencyType.IMPLEMENTATION.typeName, dep.toString())
    }
}

internal fun DependencyHandler.androidTestImplementationRecommended(recommended: GradleDependencyProvider) {
    recommended.recommendedAndroidTestGradleDependencyList().forEach { dep ->
        add(DependencyType.ANDROID_TEST_IMPLEMENTATION.typeName, dep.toString())
    }
}

internal fun DependencyHandler.testImplementationRecommended(recommended: GradleDependencyProvider) {
    recommended.recommendedTestGradleDependencyList().forEach { dep ->
        add(DependencyType.TEST_IMPLEMENTATION.typeName, dep.toString())
    }
}

internal fun DependencyHandler.kaptRecommended(recommended: GradleDependencyProvider) {
    recommended.recommendedKaptGradleDependencyList().forEach { dep ->
        add(DependencyType.KAPT.typeName, dep.toString())
    }
}