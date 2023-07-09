plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")

}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "firebase-auth"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libs.Coroutine.core)
                implementation(Libs.Koin.core)
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(Libs.Koin.android)
                implementation(Libs.Koin.compose)
                implementation(Libs.Firebase.core)
                implementation(Libs.Firebase.auth)
                implementation(Libs.Coroutine.firebase)
            }
        }
        val iosMain by getting {
            dependsOn(commonMain)
        }
    }
}

android {
    namespace = "io.spherelabs.firebaseauth"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}