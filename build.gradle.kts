// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlinVersion by extra("1.3.72")
    val navigationVersion by extra("2.1.0")

    val compileSdkVersion by extra(29)
    val minSdkVersion by extra(21)
    val targetSdkVersion by extra(29)

    // Kotlin
    val kotlinLibraries by extra(
        listOf(
            "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${AppDependencies.Versions.KOTLIN}"
        )
    )
    val kotlinCoroutineLibraries by extra(
        listOf(
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3"
        )
    )
    val kotlinCoroutineUnitTestLibraries by extra(
        listOf(
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3",
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.3"
        )
    )

    // Android KTX [Core, Lifecycle, Room, Navigation, UI, etc..]
    val ktxCoreLibraries by extra(
        listOf(
            "androidx.core:core-ktx:1.3.0",
            "androidx.fragment:fragment-ktx:1.2.5",
            "androidx.appcompat:appcompat:1.1.0"
        )
    )
    val ktxCoreUnitTestLibraries by extra(
        listOf(
            "androidx.arch.core:core-testing:2.1.0"
        )
    )
    val ktxLifecycleLibraries by extra(
        listOf(
            // Lifecycle
            "androidx.lifecycle:lifecycle-extensions:2.2.0",
            "androidx.lifecycle:lifecycle-common-java8:2.2.0",
            "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
        )
    )
    val ktxNavigationLibraries by extra(
        listOf(
            "androidx.navigation:navigation-fragment-ktx:2.2.2",
            "androidx.navigation:navigation-ui-ktx:2.2.2"
        )
    )
    val ktxRoomLibraries by extra(
        listOf(
            "androidx.room:room-ktx:2.2.5",
            "androidx.room:room-runtime:2.2.5"
        )
    )
    val ktxRoomKaptLibraries by extra(
        listOf(
            "androidx.room:room-compiler:2.2.5"
        )
    )
    val ktxRoomUnitTestLibraries by extra(
        listOf(
            "androidx.room:room-ktx:2.2.5",
            "androidx.room:room-runtime:2.2.5"
        )
    )
    val ktxUiLibraries by extra(
        listOf(
            "androidx.constraintlayout:constraintlayout:1.1.3",
            "androidx.recyclerview:recyclerview:1.1.0",
            "androidx.cardview:cardview:1.0.0",
            "com.google.android.material:material:1.1.0"
        )
    )
    val ktxInstrumentTestLibraries by extra(
        listOf(
            "junit:junit:4.13",
            "androidx.test.ext:junit-ktx:1.1.1",
            "androidx.test:runner:1.2.0",
            "androidx.test:rules:1.2.0",
            "org.hamcrest:hamcrest-library:2.2",
            "org.mockito:mockito-core:2.25.0",
            "com.nhaarman:mockito-kotlin:1.5.0",
            "androidx.test.espresso:espresso-core:3.2.0",
            "androidx.test.espresso:espresso-contrib:3.2.0"
        )
    )

    // Timber
    val timberLibraries by extra(
        listOf(
            "com.jakewharton.timber:timber:4.7.1"
        )
    )

    // Retrofit
    val retrofitLibraries by extra(
        listOf(
            "com.squareup.retrofit2:retrofit:2.9.0",
            "com.squareup.okhttp3:okhttp:4.7.2",
            "com.squareup.okhttp3:logging-interceptor:4.7.2"
        )
    )
    val retrofitConverterLibraries by extra(
        listOf(
            "com.squareup.retrofit2:converter-moshi:2.9.0"
        )
    )

    // Glide
    val glideLibraries by extra(
        listOf(
            "com.github.bumptech.glide:glide:4.11.0"
        )
    )
    val glideKaptLibraries by extra(
        listOf(
            "com.github.bumptech.glide:compiler:4.11.0"
        )
    )

    // Dagger
    val daggerLibraries by extra(
        listOf(
            "com.google.dagger:dagger-android:2.28",
            "com.google.dagger:dagger-android-support:2.28"
        )
    )
    val daggerKaptLibraries by extra(
        listOf(
            "com.google.dagger:dagger-compiler:2.28",
            "com.google.dagger:dagger-android-processor:2.28"
        )
    )
    val daggerKaptTestLibraries by extra(
        listOf(
            "com.google.dagger:dagger-compiler:2.28"
        )
    )
    val daggerKaptAndroidTestLibraries by extra(
        listOf(
            "com.google.dagger:dagger-compiler:2.28"
        )
    )

    // Extra
    val thirdPartyLibraries by extra(
        listOf(
            // Shimmer Layout
            "io.supercharge:shimmerlayout:2.1.0"
        )
    )

    // Unit Test
    val unitTestLibraries by extra(
        listOf(
            "junit:junit:4.13",
            "androidx.test:runner:1.2.0",
            "androidx.test:rules:1.2.0",
            "org.hamcrest:hamcrest-library:2.2",
            "org.mockito:mockito-core:2.25.0",
            "com.nhaarman:mockito-kotlin:1.5.0"
        )
    )
    val kotlin_version by extra("1.3.72")

    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:${AppDependencies.Versions.ANDROID_GRADLE_PLUGIN}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${AppDependencies.Versions.KOTLIN}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${AppDependencies.Versions.NAVIGATION}")
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
