plugins {
    kotlin("multiplatform")
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
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "domain"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":data:setting"))
                implementation(project(":data:firebase-auth"))

                api(Libs.Coroutine.core)
                api(Libs.Koin.core)
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
            
        }
        val iosMain by getting {
            dependsOn(commonMain)
        }
    }
}

android {
    namespace = "io.spherelabs.domain"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}