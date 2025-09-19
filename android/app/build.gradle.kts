plugins {
    id("com.android.application")
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")

    // أضف الـ Google services Gradle plugin (Firebase)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.messageme_app"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = "27.0.12077973"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.alfaqeeh.messageme_app"
        minSdk = 23
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // Import the Firebase BoM (تحديث الإصدارات تلقائياً)
    implementation(platform("com.google.firebase:firebase-bom:34.2.0"))

    // Firebase SDKs اللي تحتاجها:
    implementation("com.google.firebase:firebase-analytics")
    // مثال: لو تريد Firebase Auth
    // implementation("com.google.firebase:firebase-auth")
    // مثال: لو تريد Firestore
    // implementation("com.google.firebase:firebase-firestore")
}
