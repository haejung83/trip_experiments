plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(AppDependencies.Versions.COMPILE_SDK)
    defaultConfig {
        minSdkVersion(AppDependencies.Versions.MIN_SDK)
        targetSdkVersion(AppDependencies.Versions.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_HOST", properties["server_v1_host"] as String)
        consumerProguardFiles("consumer-rules.pro")

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }
    buildTypes {
        getByName("release") {
        }
        getByName("debug") {
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }
}

dependencies {
    // Model
    api(project(":model"))
    testImplementation(project(":test-shared"))
    testImplementation(project(":androidtest-shared"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(AppDependencies.Libs.kotlinLibraries)
    implementation(AppDependencies.Libs.kotlinCoroutineLibraries)

    // KTX
    implementation(AppDependencies.Libs.ktxLifecycleLibraries)
    implementation(AppDependencies.Libs.ktxRoomLibraries)
    kapt(AppDependencies.Libs.ktxRoomKaptLibraries)

    // Timber [API Level]
    api(AppDependencies.Libs.timberLibraries)
    // Retrofit2
    implementation(AppDependencies.Libs.retrofitLibraries)
    implementation(AppDependencies.Libs.retrofitConverterLibraries)

    // Dagger
    implementation(AppDependencies.Libs.daggerLibraries)
    kapt(AppDependencies.Libs.daggerKaptLibraries)
    kaptTest(AppDependencies.Libs.daggerKaptTestLibraries)
    // Dagger Hilt
    implementation(AppDependencies.Libs.daggerHiltLibraries)
    kapt(AppDependencies.Libs.daggerHiltKaptLibraries)
    kaptTest(AppDependencies.Libs.daggerHiltKaptLibraries)

    // Unit Testing
    testImplementation(AppDependencies.Libs.unitTestLibraries)
    // Unit Testing for KTX
    testImplementation(AppDependencies.Libs.ktxCoreUnitTestLibraries)
    // Unit Testing for Kotlin-Coroutines
    testImplementation(AppDependencies.Libs.kotlinCoroutineUnitTestLibraries)
}
