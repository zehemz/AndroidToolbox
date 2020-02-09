package com.lucasbais.android.toolbox

data class GradleDependencyInfo(
        val group: String,
        val name: String,
        val version: String,
        val description: String? = null,
        val repository: String? = null
) {
    override fun toString(): String {
        return "$group:$name:$version"
    }
}