pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "milkyway"
include(":androidApp")
include(":shared")
include(":data")
include(":data")
include(":data:network")
include(":domain")
include(":features")
include(":features:onboarding")
include(":features:auth")
include(":data:setting")
include(":data:firebase-auth")
