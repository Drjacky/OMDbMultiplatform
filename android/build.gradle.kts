val buildToolsVersion: String by project
val kotlinVersion: String by project
val androidxBaseVersion: String by project
val androidxUiVersion: String by project
val androidMaterialVersion: String by project
val androidConstraintLayoutVersion: String by project
val androidMultidexVersion: String by project

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = buildToolsVersion
    defaultConfig {
        applicationId = "app.web.drjackycv.flickrmultiplatform"
        minSdkVersion(21)
        targetSdkVersion(29)
        multiDexEnabled = true
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        val release by getting {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    sourceSets {
        val main by getting
        main.java.srcDirs("src/main/kotlin")
        main.manifest.srcFile("src/main/AndroidManifest.xml")
        main.res.srcDirs("src/main/res")
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:$androidxBaseVersion")
    implementation("androidx.core:core-ktx:$androidxBaseVersion")
    implementation("com.google.android.material:material:$androidMaterialVersion")
    implementation("androidx.constraintlayout:constraintlayout:$androidConstraintLayoutVersion")
    implementation("com.android.support:multidex:$androidMultidexVersion")
    implementation(project(":shared"))
}