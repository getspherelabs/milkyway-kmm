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
            baseName = "network"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
               implementation(Libs.Ktor.core)
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
                implementation(Libs.Ktor.okhttp)
            }
        }

        val iosMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(Libs.Ktor.darwin)
            }
        }
    }
}

android {
    namespace = "io.spherelabs.network"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}