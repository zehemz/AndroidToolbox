package com.lucasbais.android.toolbox

data class DependencyCategory(val name: String,
                              val elements: Set<GradleDependency>)