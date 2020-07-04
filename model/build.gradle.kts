plugins {
    id("java-library")
    kotlin("jvm")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(AppDependencies.Libs.kotlinLibraries)

    // Retrofit Converter
    implementation(AppDependencies.Libs.retrofitConverterLibraries)

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}