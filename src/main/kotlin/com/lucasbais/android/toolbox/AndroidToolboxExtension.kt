package com.lucasbais.android.toolbox

import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware

internal const val androidToolboxExtension = "boilerplateExtension"

fun Project.androidToolbox(configure: AndroidToolboxExtension.() -> Unit): Unit =
        (this as ExtensionAware).extensions.configure(androidToolboxExtension, configure)

open class AndroidToolboxExtension {
    var isAndroidApplication: Boolean = true
    var isAndroidLibrary: Boolean = false
    var shouldApplyDefaultRepositories: Boolean = true
    var shouldApplyDefaultDependencies: Boolean = true
    var apiLevelVersion = 29
    var apiTargetVersion = 29
    var minApiVersion = 21
    var versionCode = 1
    var versionName = "0.0.1"
}