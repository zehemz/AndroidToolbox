package com.lucasbais.android.toolbox

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.InputStreamReader

class AndroidToolboxPlugin : Plugin<Project> {

    private var project: Project? = null

    override fun apply(project: Project): Unit = project.run {

        project.afterEvaluate {

        }

        val recommendedExtension: AndroidToolboxExtension =
                project.extensions.create(
                        androidToolboxExtension,
                        AndroidToolboxExtension::class.java
                )

        configurePlugins(recommendedExtension)

        if (recommendedExtension.shouldApplyDefaultRepositories) {
            configureDefaultRepositories()
        }
        if (recommendedExtension.shouldApplyDefaultDependencies) {
            configureDefaultAndroidDependencies()
        }
    }

    private fun Project.configurePlugins(ext: AndroidToolboxExtension) {
        resolveAndroidPlugin(ext)
        plugins.apply("kotlin-android")
        plugins.apply("kotlin-android-extensions")
        plugins.apply("org.jetbrains.kotlin.kapt")
        plugins.apply("org.gradle.jacoco")
        plugins.apply("androidx.navigation.safeargs.kotlin")
    }

    private fun Project.resolveAndroidPlugin(ext: AndroidToolboxExtension) {
        if (ext.isAndroidLibrary) {
            plugins.apply("com.android.library")
            plugins.withId("com.android.library") {
                configureAndroid(ext, LibraryExtension::class.java)
            }
        } else {
            if (ext.isAndroidApplication) {
                plugins.apply("com.android.application")
                plugins.withId("com.android.application") {
                    configureAndroid(ext, BaseExtension::class.java)
                }
            } else {
                throw IllegalStateException("isAndroidApplication and isAndroidLibrary can't be both false")
            }
        }
    }

    private fun Project.configureDefaultRepositories() {
        repositories {
            recommendRepositories()
        }
    }

    private fun Project.configureDefaultAndroidDependencies() {
        dependencies {
            default()
        }
    }

    private fun DependencyHandler.default() {
        JsonReader(InputStreamReader(AndroidToolboxPlugin::class.java.getResourceAsStream("/default.json"))).use {
            val dependencies: List<DependencyCategory> = Gson().fromJson(it, object : TypeToken<List<DependencyCategory>>() {}.type)
            dependencies.forEach { dep ->
                recommended(dep)
            }
        }
    }
}

internal fun <T : BaseExtension> Project.configureAndroid(
        ext: AndroidToolboxExtension,
        javaClass: Class<T>
) =
        extensions.getByType(javaClass).run {
            compileSdkVersion(ext.apiLevelVersion)
            defaultConfig {
                minSdkVersion(ext.minApiVersion)
                targetSdkVersion(ext.apiTargetVersion)
                versionCode = ext.versionCode
                versionName = ext.versionName
                testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
                consumerProguardFiles("consumer-rules.pro")
            }

            tasks.withType<KotlinCompile> {
                kotlinOptions {
                    jvmTarget = "1.8"
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = true
                    isTestCoverageEnabled = false
                    proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
                }

                getByName("debug") {
                    isTestCoverageEnabled = true
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
        }
