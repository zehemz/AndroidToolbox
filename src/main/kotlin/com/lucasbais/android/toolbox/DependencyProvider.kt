package com.lucasbais.android.toolbox

interface GradleDependencyProvider {

    fun recommendedGradleDependencyList(): List<GradleDependency>

    fun recommendedTestGradleDependencyList(): List<GradleDependency> {
        return emptyList()
    }

    fun recommendedAndroidTestGradleDependencyList() : List<GradleDependency> {
        return emptyList()
    }

    fun recommendedKaptGradleDependencyList(): List<GradleDependency> {
        return emptyList()
    }

    fun recommendedAptGradleDependencyList(): List<GradleDependency> {
        return emptyList()
    }
}