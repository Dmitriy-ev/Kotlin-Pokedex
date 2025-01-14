plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}
apply(from = "../ktlint.gradle.kts")

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "dev.marcosfarias.pokedex"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
    }
    namespace = "dev.marcosfarias.pokedex"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Architecture
    implementation("androidx.appcompat:appcompat:1.4.2")

    implementation("androidx.navigation:navigation-ui-ktx:2.4.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.2")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")

    // Material
    implementation("com.google.android.material:material:1.6.1")

    // Third Party
    implementation("com.leinardi.android:speed-dial:3.3.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Persistence
    implementation("androidx.room:room-runtime:2.4.0-alpha03")
    kapt("androidx.room:room-compiler:2.4.0-alpha03")

    // Glide
    kapt("com.github.bumptech.glide:compiler:4.13.2")
    implementation("com.github.bumptech.glide:glide:4.13.2")

    // Koin
    implementation("io.insert-koin:koin-android:3.2.0")
    implementation("io.insert-koin:koin-core:3.2.0")
    testImplementation("io.insert-koin:koin-test:3.4.0")
    // Needed JUnit version
    testImplementation("io.insert-koin:koin-test-junit4:3.4.0")

    //allure
    androidTestImplementation("io.qameta.allure:allure-kotlin-model:2.2.7")
    androidTestImplementation("io.qameta.allure:allure-kotlin-commons:2.2.7")
    androidTestImplementation("io.qameta.allure:allure-kotlin-junit4:2.2.7")
    androidTestImplementation("io.qameta.allure:allure-kotlin-android:2.2.7")
    //Android Test Orchestrator
    androidTestUtil("androidx.test:orchestrator:1.3.0")

    // Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("com.android.support.test.espresso:espresso-contrib:3.0.2")
    androidTestImplementation("androidx.navigation:navigation-testing:2.5.3")
    debugImplementation("androidx.fragment:fragment-testing:1.6.0-alpha07")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation("io.mockk:mockk-android:1.12.4")
    testImplementation("io.mockk:mockk:1.12.4")
    androidTestImplementation("io.github.kakaocup:kakao:3.2.2")
    androidTestImplementation("com.kaspersky.android-components:kaspresso:1.5.1")
    androidTestImplementation("androidx.test:core:1.3.0")
    androidTestImplementation("androidx.test:runner:1.3.0")
    androidTestImplementation("androidx.test:rules:1.3.0")
    androidTestImplementation ("org.jetbrains.kotlin:kotlin-stdlib:1.2.51")
    androidTestImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.uiautomator:uiautomator:2.2.0")
}
