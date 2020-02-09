package com.lucasbais.android.toolbox

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class PrintTask : DefaultTask() {
    init {
        group = "com.lucasbais.android.toolbox"
        description = "Print all dependency tree"
    }

    @TaskAction
    fun run() {
        RecommendedAndroidDependencies.values().forEach {
            println(it.name)
            println(it.recommendedGradleDependencyList().toString())
            println(it.recommendedTestGradleDependencyList().toString())
            println(it.recommendedAndroidTestGradleDependencyList().toString())
            println(it.recommendedKaptGradleDependencyList().toString())
            println(it.recommendedAptGradleDependencyList().toString())
        }
    }
}