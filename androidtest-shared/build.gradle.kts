plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(AppDependencies.Versions.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(AppDependencies.Versions.MIN_SDK)
        targetSdkVersion(AppDependencies.Versions.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        getByName("release") {
        }
        getByName("debug") {
        }
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(AppDependencies.Libs.kotlinLibraries)
    // KTX Lifecycle
    implementation(AppDependencies.Libs.ktxLifecycleLibraries)

    // Testing
    implementation(AppDependencies.Libs.unitTestLibraries)
    implementation(AppDependencies.Libs.kotlinCoroutineUnitTestLibraries)
}
