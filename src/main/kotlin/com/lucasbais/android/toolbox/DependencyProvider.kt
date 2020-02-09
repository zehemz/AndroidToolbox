package com.lucasbais.android.toolbox

interface GradleDependencyProvider {

    fun get(): Set<GradleDependency>
}