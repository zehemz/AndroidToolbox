package com.lucasbais.android.toolbox

data class DependencyCategory(val name: String,
                              val dependencies: Set<GradleDependency>) : GradleDependencyProvider {

    override fun get(): Set<GradleDependency> = dependencies
}