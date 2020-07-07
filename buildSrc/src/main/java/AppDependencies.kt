object AppDependencies {

    object Versions {
        // Application
        const val appVersionName = "1.0.0"
        const val appVersionCode = 100

        // Lang
        const val KOTLIN = "1.3.72"

        // SDK
        const val COMPILE_SDK = 29
        const val MIN_SDK = 21
        const val TARGET_SDK = 29

        // ETC
        const val ANDROID_GRADLE_PLUGIN = "4.0.0"
        const val NAVIGATION = "2.1.0"
        const val HILT = "2.28-alpha"
        const val HILT_JETPACK = "1.0.0-alpha01"
    }

    object Libs {
        // Kotlin
        val kotlinLibraries =
            listOf(
                "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
            )

        val kotlinCoroutineLibraries =
            listOf(
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3"
            )

        val kotlinCoroutineUnitTestLibraries =
            listOf(
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3",
                "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.3"
            )

        // Android KTX [Core, Lifecycle, Room, Navigation, UI, etc..]
        val ktxCoreLibraries =
            listOf(
                "androidx.core:core-ktx:1.3.0",
                "androidx.fragment:fragment-ktx:1.2.5",
                "androidx.appcompat:appcompat:1.1.0"
            )

        val ktxLifecycleLibraries =
            listOf(
                // Lifecycle
                "androidx.lifecycle:lifecycle-extensions:2.2.0",
                "androidx.lifecycle:lifecycle-common-java8:2.2.0",
                "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
            )

        val ktxNavigationLibraries =
            listOf(
                "androidx.navigation:navigation-fragment-ktx:2.2.2",
                "androidx.navigation:navigation-ui-ktx:2.2.2"
            )

        val ktxRoomLibraries =
            listOf(
                "androidx.room:room-ktx:2.2.5",
                "androidx.room:room-runtime:2.2.5"
            )

        val ktxRoomKaptLibraries =
            listOf(
                "androidx.room:room-compiler:2.2.5"
            )

        val ktxRoomUnitTestLibraries =
            listOf(
                "androidx.room:room-ktx:2.2.5",
                "androidx.room:room-runtime:2.2.5"
            )

        val ktxUiLibraries =
            listOf(
                "androidx.constraintlayout:constraintlayout:1.1.3",
                "androidx.recyclerview:recyclerview:1.1.0",
                "androidx.cardview:cardview:1.0.0",
                "com.google.android.material:material:1.1.0"
            )

        // Android KTX Tests
        val ktxCoreUnitTestLibraries =
            listOf(
                "androidx.arch.core:core-testing:2.1.0"
            )

        val ktxInstrumentTestLibraries =
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

        // Timber (Logging)
        val timberLibraries =
            listOf(
                "com.jakewharton.timber:timber:4.7.1"
            )

        // Retrofit (Networking)
        val retrofitLibraries =
            listOf(
                "com.squareup.retrofit2:retrofit:2.9.0",
                "com.squareup.okhttp3:okhttp:4.7.2",
                "com.squareup.okhttp3:logging-interceptor:4.7.2"
            )

        val retrofitConverterLibraries =
            listOf(
                "com.squareup.retrofit2:converter-moshi:2.9.0"
            )

        // Glide (Image Loader)
        val glideLibraries =
            listOf(
                "com.github.bumptech.glide:glide:4.11.0"
            )

        val glideKaptLibraries =
            listOf(
                "com.github.bumptech.glide:compiler:4.11.0"
            )

        // Dagger (Dependency Injection)
        val daggerLibraries =
            listOf(
                "com.google.dagger:dagger-android:2.28",
                "com.google.dagger:dagger-android-support:2.28"
            )
        val daggerKaptLibraries =
            listOf(
                "com.google.dagger:dagger-compiler:2.28",
                "com.google.dagger:dagger-android-processor:2.28"
            )
        val daggerKaptTestLibraries =
            listOf(
                "com.google.dagger:dagger-compiler:2.28"
            )
        val daggerKaptAndroidTestLibraries =
            listOf(
                "com.google.dagger:dagger-compiler:2.28"
            )

        // Dagger Hilt
        val daggerHiltLibraries =
            listOf(
                "com.google.dagger:hilt-android:${Versions.HILT}"
            )
        val daggerHiltKaptLibraries =
            listOf(
                "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
            )
        val daggerHiltAndroidXKaptLibraries =
            listOf(
                "androidx.hilt:hilt-compiler:${Versions.HILT_JETPACK}"
            )
        val daggerHiltViewModelLibraries =
            listOf(
                "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_JETPACK}"
            )
        val daggerHiltTestingLibraries =
            listOf(
                "com.google.dagger:hilt-android-testing:${Versions.HILT}"
            )

        // Extra (UI)
        val thirdPartyLibraries =
            listOf(
                // Shimmer Layout
                "io.supercharge:shimmerlayout:2.1.0"
            )

        // Unit Test
        val unitTestLibraries =
            listOf(
                "junit:junit:4.13",
                "androidx.test:runner:1.2.0",
                "androidx.test:rules:1.2.0",
                "org.hamcrest:hamcrest-library:2.2",
                "org.mockito:mockito-core:2.25.0",
                "com.nhaarman:mockito-kotlin:1.5.0"
            )
    }

}