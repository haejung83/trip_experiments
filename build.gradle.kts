// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:${AppDependencies.Versions.ANDROID_GRADLE_PLUGIN}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${AppDependencies.Versions.KOTLIN}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${AppDependencies.Versions.NAVIGATION}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${AppDependencies.Versions.HILT}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}

subprojects {
    // TODO: Remove when the Coroutine and Flow APIs leave experimental/internal/preview.
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs +=
            "-Xuse-experimental=" +
                    "kotlin.Experimental," +
                    "kotlinx.coroutines.ExperimentalCoroutinesApi," +
                    "kotlinx.coroutines.InternalCoroutinesApi," +
                    "kotlinx.coroutines.FlowPreview"
    }
}