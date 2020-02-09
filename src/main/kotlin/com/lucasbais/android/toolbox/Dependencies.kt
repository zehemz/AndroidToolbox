package com.lucasbais.android.toolbox

const val kotlinVersion = "1.3.50"

// Kt
val kotlinStd = GradleDependency("org.jetbrains.kotlin", "kotlin-stdlib-jdk7", kotlinVersion)
val ktx = GradleDependency("androidx.core", "core-ktx", "1.0.0")

// Support
const val supportVersion = "1.0.0"
val annotation = GradleDependency("androidx.annotation", "annotation", supportVersion)
val appCompat = GradleDependency("androidx.appcompat", "appcompat", supportVersion)
val recyclerView = GradleDependency("androidx.recyclerview", "recyclerview", supportVersion)
val cardView = GradleDependency("androidx.cardview", "cardview", supportVersion)
val design = GradleDependency("com.google.android.material", "material", supportVersion)
val constraintLayout = GradleDependency("androidx.constraintlayout", "constraintlayout", "1.1.3")
val coreUtils = GradleDependency("androidx.legacy", "legacy-support-core-utils", supportVersion)
val fragment = GradleDependency("androidx.fragment", "fragment", "1.1.0")
val fragmentKtx = GradleDependency("androidx.fragment", "fragment-ktx", "1.1.0")
val navigationFragment = GradleDependency("androidx.navigation", "navigation-fragment-ktx", "2.2.1")
val navigationUI = GradleDependency("androidx.navigation", "navigation-ui-ktx", "2.2.1")

// Room database
const val roomVersion = "2.1.0"
val roomRuntime = GradleDependency("androidx.room", "room-runtime", roomVersion)
val roomCompiler = GradleDependency("androidx.room", "room-compiler", roomVersion)
val roomTesting = GradleDependency("androidx.room", "room-testing", roomVersion)
val roomRxJava2 = GradleDependency("androidx.room", "room-rxjava2", roomVersion)


// di
const val daggerVersion = "2.16"
val daggerRuntime = GradleDependency("com.google.dagger", "dagger", daggerVersion)
val daggerAndroid = GradleDependency("com.google.dagger", "dagger-android", daggerVersion)
val daggerAndroidSupport = GradleDependency("com.google.dagger", "dagger-android-support", daggerVersion)
val daggerCompiler = GradleDependency("com.google.dagger", "dagger-compiler", daggerVersion)
val daggerAndroidSupportCompiler =
        GradleDependency("com.google.dagger", "dagger-android-processor", daggerVersion)

const val lifecycleVersion = "2.1.0"
val lifecycleRuntime = GradleDependency("androidx.lifecycle", "lifecycle-runtime", lifecycleVersion)
val lifecycleJava8 = GradleDependency("androidx.lifecycle", "lifecycle-common-java8", lifecycleVersion)
val lifecycleCompiler = GradleDependency("androidx.lifecycle", "lifecycle-compiler", lifecycleVersion)
val lifecycleViewModelKtx =
        GradleDependency("androidx.lifecycle", "lifecycle-viewmodel-ktx", lifecycleVersion)
val lifecycleExtension = GradleDependency("androidx.lifecycle", "lifecycle-extensions", "2.2.0")

const val retrofitVersion = "2.7.1"
val retrofitRuntime = GradleDependency("com.squareup.retrofit2", "retrofit", retrofitVersion)
val retrofitGsonConverter = GradleDependency("com.squareup.retrofit2", "converter-gson", retrofitVersion)
val okHttp = GradleDependency("com.squareup.okhttp3", "okhttp", "4.3.1")
val mockServer = GradleDependency("com.squareup.okhttp3", "mockwebserver", "4.3.1")
val okHttpLoggingInterceptor = GradleDependency("com.squareup.okhttp3", "logging-interceptor", "4.3.1")
val moshi = GradleDependency("com.squareup.moshi", "moshi-kotlin", "1.9.2")

//Image
val glideRuntime = GradleDependency("com.github.bumptech.glide", "glide", "4.8.0")
val glideCompiler = GradleDependency("com.github.bumptech.glide", "compiler", "4.8.0")


enum class RecommendedAndroidDependencies : GradleDependencyProvider {

    LANGUAGE {
        override fun recommendedGradleDependencyList(): Set<GradleDependency> {
            return setOf(
                    kotlinStd,
                    ktx
            )
        }
    },
    UI {
        override fun recommendedGradleDependencyList(): Set<GradleDependency> {
            return setOf(
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
                    navigationUI
            )
        }

        override fun recommendedTestGradleDependencyList(): Set<GradleDependency> {
            return setOf(
                    appCompat,
                    recyclerView,
                    cardView,
                    design
            )
        }
    },
    DATABASE {
        override fun recommendedGradleDependencyList(): Set<GradleDependency> {
            return setOf(
                    roomRuntime,
                    roomRxJava2
            )
        }

        override fun recommendedKaptGradleDependencyList(): Set<GradleDependency> {
            return setOf(
                    roomCompiler
            )
        }

        override fun recommendedTestGradleDependencyList(): Set<GradleDependency> {
            return setOf(
                    roomTesting
            )
        }
    },
    DI {
        override fun recommendedGradleDependencyList(): Set<GradleDependency> {
            return setOf(
                    daggerRuntime,
                    daggerAndroid,
                    daggerAndroidSupport
            )
        }

        override fun recommendedKaptGradleDependencyList(): Set<GradleDependency> {
            return setOf(
                    daggerCompiler,
                    daggerAndroidSupportCompiler
            )
        }

    },
    IMAGES {
        override fun recommendedGradleDependencyList(): Set<GradleDependency> {
            return setOf(glideRuntime)
        }

        override fun recommendedKaptGradleDependencyList(): Set<GradleDependency> {
            return setOf(glideCompiler)
        }
    },
    ARCHITECTURE {
        override fun recommendedGradleDependencyList(): Set<GradleDependency> {
            return setOf(
                    lifecycleRuntime,
                    lifecycleJava8,
                    lifecycleViewModelKtx,
                    lifecycleExtension
            )
        }

        override fun recommendedKaptGradleDependencyList(): Set<GradleDependency> {
            return setOf(lifecycleCompiler)
        }

    },
    NETWORK {
        override fun recommendedGradleDependencyList(): Set<GradleDependency> {
            return setOf(
                    retrofitRuntime,
                    retrofitGsonConverter,
                    okHttp,
                    okHttpLoggingInterceptor,
                    moshi
            )
        }

        override fun recommendedTestGradleDependencyList(): Set<GradleDependency> {
            return setOf(mockServer)
        }
    },
    LOGS {
        override fun recommendedGradleDependencyList(): Set<GradleDependency> {
            return setOf(GradleDependency("com.jakewharton.timber", "timber", "4.5.1"))
        }
    }
}