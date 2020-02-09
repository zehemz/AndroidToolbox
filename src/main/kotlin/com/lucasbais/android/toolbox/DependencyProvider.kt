package com.lucasbais.android.toolbox

interface GradleDependencyProvider {

    fun recommendedGradleDependencyList(): Set<GradleDependency>

    fun recommendedTestGradleDependencyList(): Set<GradleDependency> {
        return emptySet()
    }

    fun recommendedAndroidTestGradleDependencyList(): Set<GradleDependency> {
        return emptySet()
    }

    fun recommendedKaptGradleDependencyList(): Set<GradleDependency> {
        return emptySet()
    }

    fun recommendedAptGradleDependencyList(): Set<GradleDependency> {
        return emptySet()
    }
}