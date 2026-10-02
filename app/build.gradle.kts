plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.dokka)
}

android {
    namespace = "com.example.sendmessage"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.sendmenssage"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
    //Libreria de github que nos permite aádir un botón about us de github

}
// Configuración de rutas personalizadas para Dokka V2
tasks.withType<org.jetbrains.dokka.gradle.tasks.DokkaGenerateTask>().configureEach {
    outputDirectory.set(layout.projectDirectory.dir("../documentation/html"))
}

// Alias para mantener compatibilidad con el comando ./gradlew dokkaHtml
dokka {
    moduleName.set("SendMessage") //Este nombre puede ser aleatorio, pero conviene que sea el del proyecto

    dokkaPublications.html {
        outputDirectory.set(rootProject.file("documentation"))
    }

    dokkaSourceSets {
        register("main") {
            //sourceRoots.from(file("src/main/java"))
            jdkVersion.set(11)
            enableAndroidDocumentationLink.set(false)
        }
    }
}