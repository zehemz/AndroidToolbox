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
    recommended.get().forEach {
        it.add(this)
    }
}