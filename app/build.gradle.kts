plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(AppDependencies.Versions.COMPILE_SDK)

    defaultConfig {
        minSdkVersion(AppDependencies.Versions.MIN_SDK)
        targetSdkVersion(AppDependencies.Versions.TARGET_SDK)
        applicationId = "kr.tripstore.proto"
        versionCode = AppDependencies.Versions.appVersionCode
        versionName = AppDependencies.Versions.appVersionName
        testInstrumentationRunner = "kr.tripstore.proto.tests.TsTestCustomRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
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

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    // Shared
    implementation(project(":shared"))
    testImplementation(project(":test-shared"))
    testImplementation(project(":androidtest-shared"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(AppDependencies.Libs.kotlinLibraries)
    implementation(AppDependencies.Libs.kotlinCoroutineLibraries)

    // KTX
    implementation(AppDependencies.Libs.ktxCoreLibraries)
    implementation(AppDependencies.Libs.ktxLifecycleLibraries)
    implementation(AppDependencies.Libs.ktxNavigationLibraries)
    implementation(AppDependencies.Libs.ktxUiLibraries)

    // Glide
    implementation(AppDependencies.Libs.glideLibraries)
    kapt(AppDependencies.Libs.glideKaptLibraries)

    // Dagger
    implementation(AppDependencies.Libs.daggerLibraries)
    kapt(AppDependencies.Libs.daggerKaptLibraries)
    kaptTest(AppDependencies.Libs.daggerKaptTestLibraries)
    kaptAndroidTest(AppDependencies.Libs.daggerKaptAndroidTestLibraries)
    // Dagger Hilt
    implementation(AppDependencies.Libs.daggerHiltLibraries)
    implementation(AppDependencies.Libs.daggerHiltViewModelLibraries)
    androidTestImplementation(AppDependencies.Libs.daggerHiltTestingLibraries)
    kapt(AppDependencies.Libs.daggerHiltKaptLibraries)
    kapt(AppDependencies.Libs.daggerHiltAndroidXKaptLibraries)
    kaptAndroidTest(AppDependencies.Libs.daggerHiltKaptLibraries)
    kaptAndroidTest(AppDependencies.Libs.daggerHiltAndroidXKaptLibraries)

    // Extra
    implementation(AppDependencies.Libs.thirdPartyLibraries)

    // Unit Testing
    testImplementation(AppDependencies.Libs.unitTestLibraries)
    // Unit Testing for KTX
    testImplementation(AppDependencies.Libs.ktxCoreUnitTestLibraries)
    testImplementation(AppDependencies.Libs.ktxRoomUnitTestLibraries)
    // Unit Testing for Kotlin-Coroutines
    testImplementation(AppDependencies.Libs.kotlinCoroutineUnitTestLibraries)

    // Instrumented Testing
    androidTestImplementation(AppDependencies.Libs.ktxInstrumentTestLibraries)
}
