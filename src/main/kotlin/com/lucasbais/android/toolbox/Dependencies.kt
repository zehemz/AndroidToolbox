package com.lucasbais.android.toolbox

const val kotlinVersion = "1.3.70"

// Kt
val kotlinStd = GradleDependencyInfo("org.jetbrains.kotlin", "kotlin-stdlib-jdk7", kotlinVersion)
val ktx = GradleDependencyInfo("androidx.core", "core-ktx", "1.3.0")

// Support
const val supportVersion = "1.1.0"
const val roomVersion = "2.2.5"
const val daggerVersion = "2.28.3"
const val lifecycleVersion = "2.2.0"
const val retrofitVersion = "2.9.0"
const val glideVersion = "4.11.0"
const val navigationVersion = "2.3.0"
const val fragmentVersion = "1.2.5"
const val pagingVersion = "2.1.2"

val annotation = GradleDependencyInfo("androidx.annotation", "annotation", supportVersion)
val appCompat = GradleDependencyInfo("androidx.appcompat", "appcompat", supportVersion)
val recyclerView = GradleDependencyInfo("androidx.recyclerview", "recyclerview", supportVersion)
val cardView = GradleDependencyInfo("androidx.cardview", "cardview", "1.0.0")
val design = GradleDependencyInfo("com.google.android.material", "material", "1.2.0")
val constraintLayout = GradleDependencyInfo("androidx.constraintlayout", "constraintlayout", "1.1.3")
val coreUtils = GradleDependencyInfo("androidx.legacy", "legacy-support-core-utils", "1.0.0")

val fragment = GradleDependencyInfo("androidx.fragment", "fragment", fragmentVersion)
val fragmentKtx = GradleDependencyInfo("androidx.fragment", "fragment-ktx", fragmentVersion)

val navigationFragment = GradleDependencyInfo("androidx.navigation", "navigation-fragment-ktx", navigationVersion)
val navigationUI = GradleDependencyInfo("androidx.navigation", "navigation-ui-ktx", navigationVersion)

val pagination = GradleDependencyInfo("androidx.paging", "paging-runtime", pagingVersion)


// Room database

val roomGroup = "androidx.room"
val roomRuntime = GradleDependencyInfo(roomGroup, "room-runtime", roomVersion)
val roomCompiler = GradleDependencyInfo(roomGroup, "room-compiler", roomVersion)
val roomTesting = GradleDependencyInfo(roomGroup, "room-testing", roomVersion)
val roomRxJava2 = GradleDependencyInfo(roomGroup, "room-rxjava2", roomVersion)


// di
val daggerRuntime = GradleDependencyInfo("com.google.dagger", "dagger", daggerVersion)
val daggerAndroid = GradleDependencyInfo("com.google.dagger", "dagger-android", daggerVersion)
val daggerAndroidSupport = GradleDependencyInfo("com.google.dagger", "dagger-android-support", daggerVersion)
val daggerCompiler = GradleDependencyInfo("com.google.dagger", "dagger-compiler", daggerVersion)
val daggerAndroidSupportCompiler =
        GradleDependencyInfo("com.google.dagger", "dagger-android-processor", daggerVersion)

val lifecycleRuntime = GradleDependencyInfo("androidx.lifecycle", "lifecycle-runtime", lifecycleVersion)
val lifecycleJava8 = GradleDependencyInfo("androidx.lifecycle", "lifecycle-common-java8", lifecycleVersion)
val lifecycleCompiler = GradleDependencyInfo("androidx.lifecycle", "lifecycle-compiler", lifecycleVersion)
val lifecycleViewModelKtx =
        GradleDependencyInfo("androidx.lifecycle", "lifecycle-viewmodel-ktx", lifecycleVersion)
val lifecycleExtension = GradleDependencyInfo("androidx.lifecycle", "lifecycle-extensions", lifecycleVersion)

val retrofitRuntime = GradleDependencyInfo("com.squareup.retrofit2", "retrofit", retrofitVersion)
val retrofitGsonConverter = GradleDependencyInfo("com.squareup.retrofit2", "converter-gson", retrofitVersion)
val okHttp = GradleDependencyInfo("com.squareup.okhttp3", "okhttp", "4.3.1")
val mockServer = GradleDependencyInfo("com.squareup.okhttp3", "mockwebserver", "4.3.1")
val okHttpLoggingInterceptor = GradleDependencyInfo("com.squareup.okhttp3", "logging-interceptor", "4.3.1")
val moshi = GradleDependencyInfo("com.squareup.moshi", "moshi-kotlin", "1.9.2")

//Image
val glideRuntime = GradleDependencyInfo("com.github.bumptech.glide", "glide", glideVersion)
val glideCompiler = GradleDependencyInfo("com.github.bumptech.glide", "compiler", glideVersion)


enum class RecommendedAndroidDependencies : GradleDependencyProvider {

    LANGUAGE {
        override fun get(): Set<GradleDependency> {
            return setOf(GradleDependency("implementation", setOf(
                    kotlinStd,
                    ktx
            )))
        }
    },
    UI {
        override fun get(): Set<GradleDependency> {
            return setOf(GradleDependency("implementation", setOf(
                    annotation,
                    appCompat,
                    recyclerView,
                    cardView,
                    design,
                    constraintLayout,
                    fragment,
                    fragmentKtx,
                    coreUtils,
                    navigationFragment,
                    navigationUI,
                    pagination
            )), GradleDependency("testImplementation", setOf(
                    appCompat,
                    recyclerView,
                    cardView,
                    design
            )))
        }
    },
    DATABASE {
        override fun get(): Set<GradleDependency> {
            return setOf(GradleDependency("implementation", setOf(
                    roomRuntime,
                    roomRxJava2
            )), GradleDependency("kapt", setOf(
                    roomCompiler
            )), GradleDependency("testImplementation", setOf(roomTesting)))
        }
    },
    DI {
        override fun get(): Set<GradleDependency> {
            return setOf(GradleDependency("implementation", setOf(
                    daggerRuntime,
                    daggerAndroid,
                    daggerAndroidSupport
            )), GradleDependency("kapt", setOf(daggerCompiler,
                    daggerAndroidSupportCompiler)))
        }
    },
    IMAGES {

        override fun get(): Set<GradleDependency> {
            return setOf(GradleDependency("implementation", setOf(
                    glideRuntime
            )), GradleDependency("kapt", setOf(glideCompiler)))
        }
    },
    ARCHITECTURE {
        override fun get(): Set<GradleDependency> {
            return setOf(GradleDependency("implementation", setOf(
                    lifecycleRuntime,
                    lifecycleJava8,
                    lifecycleViewModelKtx,
                    lifecycleExtension
            )), GradleDependency("kapt", setOf(lifecycleCompiler)))
        }
    },
    NETWORK {
        override fun get(): Set<GradleDependency> {
            return setOf(GradleDependency("implementation", setOf(
                    retrofitRuntime,
                    retrofitGsonConverter,
                    okHttp,
                    okHttpLoggingInterceptor,
                    moshi
            )), GradleDependency("testImplementation", setOf(mockServer)))
        }
    },
    LOGS {
        override fun get(): Set<GradleDependency> {
            return setOf(GradleDependency("implementation", setOf(GradleDependencyInfo("com.jakewharton.timber", "timber", "4.5.1"))))
        }
    }
}