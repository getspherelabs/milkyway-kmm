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
            baseName = "setting"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(Libs.Settings.coroutine)
                api(Libs.Settings.core)
                api(Libs.Koin.core)
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
                implementation(Libs.Android.datastore)
                implementation(Libs.Android.datastorePref)
                api(Libs.Settings.datastore)
            }
        }

        val iosMain by getting {
            dependsOn(commonMain)
        }
    }
}

android {
    namespace = "io.spherelabs.setting"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}