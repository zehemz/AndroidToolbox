package com.lucasbais.android.toolbox

data class GradleDependency(
    val packageName: String,
    val name: String,
    val version: String
) {
    override fun toString(): String {
        return "$packageName:$name:$version"
    }
}