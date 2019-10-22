import java.time.LocalDate.now

plugins {
    // write with kotlin dsl
    `kotlin-dsl`
    // publish plugins
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.4"
}

repositories {
    google()
    jcenter()
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

dependencies {
    /* Depend on the android gradle plugin, since we want to access it in our plugin */
    api("com.android.tools.build:gradle:3.5.1")

    /* Depend on the kotlin plugin, since we want to access it in our plugin */
    api("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")

    /* Depend on the default Gradle API's since we want to build a custom plugin */
    implementation(gradleApi())

    /* Depend on local groovy files */
    implementation(localGroovy())
}

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "5.6.2"
        distributionType = Wrapper.DistributionType.BIN
    }
}


//////////// Deploy section ////////////////////////////////////

// Needed for group and version generation
group = "com.lucasbais.android"
version = "0.0.1"

val bintrayUser: String? = System.getenv("BINTRAY_USER")
val bintrayApiKey: String? = System.getenv("BINTRAY_API_KEY")

tasks {
    val sourcesJar by creating(Jar::class) {
        dependsOn(JavaPlugin.CLASSES_TASK_NAME)
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }

    artifacts {
        archives(sourcesJar)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = "AndroidToolbox"
            version = project.version.toString()
            from(components["java"])
        }
    }
}

bintray {
    user = bintrayUser
    key = bintrayApiKey
    publish = true
    override = true

    pkg.apply {
        repo = "android"
        name = "AndroidToolbox"
        //userOrg = user
        publicDownloadNumbers = true
        issueTrackerUrl = "https://github.com/zehemz/AndroidToolbox/issues"
        vcsUrl = "https://github.com/zehemz/AndroidToolbox.git"
        version.apply {
            name = project.version.toString()
            desc = "Android Toolbox plugin :)"
            vcsTag = name
        }

        setPublications("maven")
        setConfigurations("archives")
        setLicenses("Apache-2.0")

    }
}