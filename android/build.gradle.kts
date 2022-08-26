plugins {
    id("org.jetbrains.compose") version "1.1.0"
    id("com.android.application")
    kotlin("android")
}

group = "jiaozhu.com"
version = "1.0"

repositories {
    jcenter()
}

dependencies {
    implementation(project(":common"))
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "jiaozhu.com.android"
        minSdkVersion(24)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}