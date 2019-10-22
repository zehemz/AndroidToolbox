# AndroidToolbox

AndroidToolbox is a gradle plugin that helps you to start projects in seconds.

It aims to resolve all the dependency and configurations issues for you.


## Usage

```kotlin
allprojects {
    group = "com.lucasbais.android"
    version = "0.0.1"
}

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.lucasbais.android:AndroidToolbox:0.0.1")
    }
}

subprojects {
    apply(plugin = "com.lucasbais.android.toolbox")
}
```