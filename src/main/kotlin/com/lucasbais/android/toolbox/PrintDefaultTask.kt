package com.lucasbais.android.toolbox

import com.google.gson.GsonBuilder
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class PrintDefaultTask : DefaultTask() {

    private val gson = GsonBuilder().setPrettyPrinting().create()

    init {
        group = "other"
        description = "Print all android toolbox default dependencies"
    }

    @TaskAction
    fun run() {
        RecommendedAndroidDependencies.values().map {
            DependencyCategory(it.name, it.get())
        }.apply {
            println(gson.toJson(this))
        }
    }
}