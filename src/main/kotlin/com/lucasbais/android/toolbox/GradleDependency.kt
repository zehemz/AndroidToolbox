package com.lucasbais.android.toolbox

import org.gradle.api.artifacts.dsl.DependencyHandler

data class GradleDependency(val methodName: String, val dependencyInfos: Set<GradleDependencyInfo> = emptySet()) {

    fun add(dependencyHandler: DependencyHandler) {
        dependencyInfos.forEach {
            dependencyHandler.add(methodName, it.toString())
        }
    }
}