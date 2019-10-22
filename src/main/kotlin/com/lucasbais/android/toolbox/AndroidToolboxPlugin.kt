package com.lucasbais.android.toolbox

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.repositories
import java.lang.IllegalStateException

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
        recommended(RecommendedAndroidDependencies.ANDROID_SUPPORT)
        recommended(RecommendedAndroidDependencies.KOTLIN)
        recommended(RecommendedAndroidDependencies.ROOM)
        recommended(RecommendedAndroidDependencies.DAGGER)
        recommended(RecommendedAndroidDependencies.GLIDE)
        recommended(RecommendedAndroidDependencies.LIFECYCLE)
        recommended(RecommendedAndroidDependencies.RETROFIT)
        recommended(RecommendedAndroidDependencies.TIMBER)
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
