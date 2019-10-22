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

// Room database
const val roomVersion = "2.1.0"
val roomRuntime = GradleDependency("androidx.room", "room-runtime", roomVersion)
val roomCompiler = GradleDependency("androidx.room", "room-compiler", roomVersion)
val roomTesting = GradleDependency("androidx.room", "room-testing", roomVersion)
val roomRxJava2 = GradleDependency("androidx.room", "room-rxjava2", roomVersion)


// Dagger
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

const val retrofitVersion = "2.3.0"
val retrofitRuntime = GradleDependency("com.squareup.retrofit2", "retrofit", retrofitVersion)
val retrofitGsonConverter = GradleDependency("com.squareup.retrofit2", "converter-gson", retrofitVersion)

// glide image load
val glideRuntime = GradleDependency("com.github.bumptech.glide", "glide", "4.8.0")
val glideCompiler = GradleDependency("com.github.bumptech.glide", "compiler", "4.8.0")


enum class RecommendedAndroidDependencies : GradleDependencyProvider {

    KOTLIN {
        override fun recommendedGradleDependencyList(): List<GradleDependency> {
            return listOf(
                    kotlinStd,
                    ktx
            )
        }
    },
    ANDROID_SUPPORT {
        override fun recommendedGradleDependencyList(): List<GradleDependency> {
            return listOf(
                    annotation,
                    appCompat,
                    recyclerView,
                    cardView,
                    design,
                    constraintLayout,
                    fragment,
                    fragmentKtx,
                    coreUtils
            )
        }

        override fun recommendedTestGradleDependencyList(): List<GradleDependency> {
            return listOf(
                    appCompat,
                    recyclerView,
                    cardView,
                    design
            )
        }
    },
    ROOM {
        override fun recommendedGradleDependencyList(): List<GradleDependency> {
            return listOf(
                    roomRuntime,
                    roomRxJava2
            )
        }

        override fun recommendedKaptGradleDependencyList(): List<GradleDependency> {
            return listOf(
                    roomCompiler
            )
        }

        override fun recommendedTestGradleDependencyList(): List<GradleDependency> {
            return listOf(
                    roomTesting
            )
        }
    },
    DAGGER {
        override fun recommendedGradleDependencyList(): List<GradleDependency> {
            return listOf(
                    daggerRuntime,
                    daggerAndroid,
                    daggerAndroidSupport
            )
        }

        override fun recommendedKaptGradleDependencyList(): List<GradleDependency> {
            return listOf(
                    daggerCompiler,
                    daggerAndroidSupportCompiler
            )
        }

    },
    GLIDE {
        override fun recommendedGradleDependencyList(): List<GradleDependency> {
            return listOf(glideRuntime)
        }

        override fun recommendedKaptGradleDependencyList(): List<GradleDependency> {
            return listOf(glideCompiler)
        }
    },
    LIFECYCLE {
        override fun recommendedGradleDependencyList(): List<GradleDependency> {
            return listOf(
                    lifecycleRuntime,
                    lifecycleJava8,
                    lifecycleViewModelKtx
            )

        }

        override fun recommendedKaptGradleDependencyList(): List<GradleDependency> {
            return listOf(lifecycleCompiler)
        }

    },
    RETROFIT {
        override fun recommendedGradleDependencyList(): List<GradleDependency> {
            return listOf(
                    retrofitRuntime,
                    retrofitGsonConverter
            )
        }
    },
    TIMBER {
        override fun recommendedGradleDependencyList(): List<GradleDependency> {
            return listOf(GradleDependency("com.jakewharton.timber", "timber", "4.5.1"))
        }
    }
}